package com.qingan.feign;

import com.qingan.domain.Order;
import com.qingan.feign.hystrix.UserOrderFeignIHsystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author qingAn
 * @Date 2022/10/19 1:16
 */
@FeignClient(value = "order-service",fallback = UserOrderFeignIHsystrix.class)
public interface UserOrderFeign {
    //查询订单
    @GetMapping("/order/getOrderByUserId")
    Order getOrderByUserId(@RequestBody Integer userId);
}
