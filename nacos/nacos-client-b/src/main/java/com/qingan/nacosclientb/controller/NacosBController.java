package com.qingan.nacosclientb.controller;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author qingAn
 * @date 2022/10/06 22:51
 */
@RestController
@Setter
//@RefreshScope(proxyMode = ScopedProxyMode.DEFAULT)
@ConfigurationProperties(prefix = "pattern")
public class NacosBController {

    //@Value("${pattern.dateformat}")
    private String dateformat;

    private String envSharedValue;

    @GetMapping("/info")
    private String hello(){
        System.out.println(envSharedValue);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformat)));
        return "hello world";
    }
}
