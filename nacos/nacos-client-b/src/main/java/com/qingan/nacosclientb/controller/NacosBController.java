package com.qingan.nacosclientb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qingAn
 * @date 2022/10/06 22:51
 */
@RestController
public class NacosBController {

    @GetMapping("/info")
    private String hello(){
        return "hello world";
    }
}
