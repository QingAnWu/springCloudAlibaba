package com.qingan.nacosclienta.controller;

import com.qingan.nacosclienta.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qingAn
 * @date 2022/10/06 21:35
 */
@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private TestFeign testFeign;

    @GetMapping
   private String test(){
        List<ServiceInstance> instances = discoveryClient.getInstances("nacos-client");
        System.out.println("instances = " + instances);
        return testFeign.hello();
   }
}
