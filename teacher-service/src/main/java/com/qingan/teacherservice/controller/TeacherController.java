package com.qingan.teacherservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qingAn
 * @Date 2022/10/20 23:24
 */
@RestController
public class TeacherController {

    @GetMapping("teach")
    public String teach(){
        return "OK";
    }
}
