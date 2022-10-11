package com.qingan.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @FeignClient(value = "order-service")
 * value就是提供者的应用名称
 * @author qingAn
 * @date 2022/10/10 12:00
 */
@FeignClient("order-service")
public interface UserOrderFeign {


    /**
     * 你需要调用哪个controller 就写它的方法签名
     * 方法签名(就是包含一个方法的所有属性)
     */
    @GetMapping("doOrder")
    String doOrder();
}
