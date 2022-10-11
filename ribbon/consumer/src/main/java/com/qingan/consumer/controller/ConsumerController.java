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

    /**
     *  方法一
     *  ribbon是怎么将http:provider/hello 路径请求成功的
     *  http://127.0.0.1:8080/hello
     *  1.拦截请求
     *  2.截取主机名称
     *  3.借助eureka来做服务发现list<>
     *  4.通过负载均衡算法 拿到一个服务ip port
     *  5.reConstructURL
     *  6.发起请求
     *
     *  Ribbon:我们这里的地址，应该是一个变量，通过服务名来访问
     */
    @GetMapping("testRibbonA")
    public String testRibbon(String serviceName){
        return restTemplate.getForObject("http://" + serviceName + "/hello", String.class);
    }

    /**
     * 方法二
     * Ribbon:我们这里的地址，应该是一个变量，通过服务名来访问
     */
    private static final String SERVICE_NAME = "provider";

    @GetMapping("testRibbonB")
    public String testRibbon(){
        return restTemplate.getForObject("http://" + SERVICE_NAME + "/hello", String.class);
    }


}
