package com.qingan.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qingAn
 * @date 2022/10/08 22:10
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("testRibbon")
    public String testRibbon(String serviceName){
        return restTemplate.getForObject("http://" + serviceName + "/hello", String.class);
    }
}
