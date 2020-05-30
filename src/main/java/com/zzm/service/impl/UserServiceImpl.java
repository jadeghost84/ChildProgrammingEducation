package com.zzm.service.impl;

import com.zzm.dao.UserDao;
import com.zzm.domain.User;
import com.zzm.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private RedisTemplate redisTemplate;

    //验证码长度
    private Integer codeLength = 5;
    //验证码存在redis中的时长，单位秒
    int codeTimeKeep = 200;
    //用户保持登录状态持续的时间,单位为分钟
    int loginTimeKeep = 5;


    @Override
    public List<User> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        return userDao.findAll();
    }

    @Override
    public User findUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        return userDao.findUserById(id);
    }

    @Override
    public List<User> findUserByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        return userDao.findUserByName(name);
    }

    @Override
    public Integer saveUser(User user,String checkCode) {
        if(checkCode.equals(redisTemplate.opsForValue().get(user.getPhone()))){
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            userDao.saveUser(user);
  //          sqlSession.commit();//开启springboot自动事务控制就不用自己提交啦。

            return 1;
        }
        //创建用户失败
        return 0;
    }
//实现登录业务
    @Override
    public User login(String phone, String u_password,String sessionId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserByPhoneAndPassword(phone, u_password);
//        if(user!=null){
//            //以sessionId为key，存储用户id
//            redisTemplate.opsForValue().set(sessionId,user.getU_id(),loginTimeKeep,TimeUnit.MINUTES);
//        }
        return user;
    }
//实现产出、发送、保存手机验证码功能
    @Override
    public void getCheckCode(String phone) {
        Random random = new Random();
        String checkCode = "";

        for(int i = 0;i<codeLength;i++){
            checkCode += random.nextInt(10);
        }
        System.out.println("此次注册的验证码："+checkCode);
        redisTemplate.opsForValue().set(phone,checkCode,codeTimeKeep, TimeUnit.SECONDS);
    }

    @Override
    public User getUserInfo(Integer u_id) {
        if(u_id != -1){
            User user = findUserById(u_id);
            return user;
        }
        return null;
    }

//    //判定此用户session是否登录
//    @Override
//    public Integer isLogin(String sessionId) {
//        Object u_id = redisTemplate.opsForValue().get(sessionId);
//        if(u_id!=null){
//            return (Integer) u_id;
//        };
//        return -1;
//    }

//    @Override
//    public void exitLogin(String sessionId) {
//        redisTemplate.delete(sessionId);
//    }
}
