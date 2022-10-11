package com.qingan.orderservice.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author qingAn
 * @date 2022/10/10 20:38
 */
@RestController
public class ParamController {

    @GetMapping("/testUrl/{name}/{age}")
    private String testUrl(@PathVariable("name") String name ,@PathVariable("age") Integer age){
        System.out.println(name+": "+age);
        return "OK";
    }

}
