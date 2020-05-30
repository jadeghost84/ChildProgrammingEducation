package com.zzm.programmingedu;

import com.zzm.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTest {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserService userService;
    @Test
    public void redisTest(){
        redisTemplate.opsForValue().set("ss","hello",3000,TimeUnit.SECONDS);
        System.out.println(redisTemplate.opsForValue().get("ss"));
        System.out.println(redisTemplate.opsForValue().get("18407838900"));
    }
    @Test
    public void sessionTest(){
        userService.login("18407838900","123456","12345");
        userService.login("18407838900","123456","456376");
        userService.login("18407838900","123456","哈喽");


    }
}
