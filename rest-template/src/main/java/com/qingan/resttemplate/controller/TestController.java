package com.qingan.resttemplate.controller;

import com.qingan.resttemplate.domin.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qingAn
 * @date 2022/10/08 14:38
 */
@RestController
public class TestController {

    @GetMapping("get")
    private String get(String name){
        System.out.println(name);
        return "OK";
    }

    /**
     * json参数
     * @param user
     * @return
     */
    @PostMapping("postA")
    private String postA(@RequestBody User user){
        System.out.println(user);
        return "Ok";
    }

    /**
     * 表单参数
     * @param user
     * @return
     */
    @PostMapping("postB")
    private String postB(User user){
        System.out.println(user);
        return "OK";
    }
}
