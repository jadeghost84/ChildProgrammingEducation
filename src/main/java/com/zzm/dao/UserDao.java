package com.zzm.dao;

import com.zzm.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("userDao")
@Mapper
public interface UserDao {

    public List<User> findAll();

    public User findUserById(Integer u_id);


    public List<User> findUserByName(String u_name);

    public void saveUser(User user);

    public User findUserByPhoneAndPassword(String phone,String u_password);

}
