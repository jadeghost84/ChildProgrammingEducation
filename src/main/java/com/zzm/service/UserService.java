package com.zzm.service;

import com.zzm.domain.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findUserById(int id);
    public List<User> findUserByName(String name);
    public Integer saveUser(User user,String checkCode);
    public User login(String phone,String u_password,String sessionId);
    public void getCheckCode(String phone);
    //根据客户端传过来的sessionId判断是否登录，登录就返回用户数据
    public User getUserInfo(Integer u_id);
    //通过查找redis判断是否登录,已登录返回u_id，未登录返回-1
 //   public Integer isLogin(String sessionId);
    //退出登录
  //  public void exitLogin(String sessionId);
}
