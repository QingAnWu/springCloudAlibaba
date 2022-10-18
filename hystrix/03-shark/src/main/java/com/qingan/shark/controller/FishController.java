package com.qingan.shark.controller;

import com.qingan.shark.anno.Shark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author qingAn
 * @Date 2022/10/18 14:24
 */
@RestController
public class FishController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("doRpc")
    @Shark
    public String doRpc() {
        String result = restTemplate.getForObject("http://localhost:8989/abc", String.class);
        return result;
    }

}
