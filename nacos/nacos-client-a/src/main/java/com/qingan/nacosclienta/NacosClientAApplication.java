package com.qingan.nacosclienta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 吴
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@RibbonClient(name = "nacos-client",configuration = RandomRule.class)
public class NacosClientAApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosClientAApplication.class, args);
    }

}
