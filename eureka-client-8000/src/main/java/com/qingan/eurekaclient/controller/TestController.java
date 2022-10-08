package com.qingan.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qingAn
 * @date 2022/10/07 8:36
 */
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    private String test(){
        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-CLIENT-8001");
        ServiceInstance serviceInstance = instances.get(0);
        System.out.println("getInstanceId => "+ serviceInstance.getInstanceId());
        System.out.println("getServiceId => "+ serviceInstance.getServiceId());
        System.out.println("getHost => "+ serviceInstance.getHost());
        System.out.println("getMetadata => "+ serviceInstance.getMetadata());
        System.out.println("getPort => "+ serviceInstance.getPort());
        System.out.println("getUri => "+ serviceInstance.getUri());
        System.out.println("getScheme => "+ serviceInstance.getScheme());
        return "OK";
    }

}
