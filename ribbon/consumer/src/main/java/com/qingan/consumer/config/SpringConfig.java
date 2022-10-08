package com.qingan.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author qingAn
 * @date 2022/10/08 22:12
 */
@Configuration
public class SpringConfig {

    /**
     * LoadBalanced 配置负载均衡实现RestTemplate
     * 被ribbon来操作
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
