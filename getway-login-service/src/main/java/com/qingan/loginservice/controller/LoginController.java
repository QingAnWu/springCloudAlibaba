package com.qingan.loginservice.controller;

import com.qingan.loginservice.domin.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.UUID;

/**
 * @Author qingAn
 * @Date 2022/10/20 9:30
 */
@RestController
public class LoginController {

    @Autowired
    public StringRedisTemplate redisTemplate;

    @GetMapping("doLogin")
    public String doLogin(String name , String pwd){
        System.out.println(name);
        System.out.println(pwd);

        User user = new User(1, "root", "root", 18);
        String token = UUID.randomUUID().toString();

        redisTemplate.opsForValue().set(token,user.toString(), Duration.ofSeconds(7200));

        return token;
    }
}
