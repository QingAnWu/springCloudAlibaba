package com.qingan.orderservice.controller;

import com.qingan.orderservice.admin.Order;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

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

    @GetMapping("/oneParam")
    private String oneParam(@RequestParam(required = false) String name){
        System.out.println("name: "+name);
        return "OK";
    }

    @GetMapping("/twoParam")
    private String twoParam(@RequestParam(required = false) String name,@RequestParam(required = false) Integer age){
        System.out.println("name: "+name);
        System.out.println("age: "+name);
        return "OK";
    }

    @PostMapping("/oneObj")
    private String oneObj(@RequestBody Order order){
        System.out.println("order = " + order);
        return "OK";
    }

    @PostMapping("/oneObjOneParam")
    private String oneObjOneParam(@RequestBody Order order,@RequestParam(required = false) String name){
        System.out.println("order = " + order);
        System.out.println("name = " + name);
        return "OK";
    }

    @PostMapping("/testTime")
    private String testTime(@RequestBody LocalDateTime date){
        System.out.println("date = " + date);
        return "OK";
    }

}
