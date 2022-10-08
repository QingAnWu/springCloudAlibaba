package com.qingan.providera.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qingAn
 * @date 2022/10/08 21:54
 */
@RestController
public class ProviderController {

    @GetMapping("hello")
    private String hello(){
        return "我是提供者 A 的接口";
    }
}
