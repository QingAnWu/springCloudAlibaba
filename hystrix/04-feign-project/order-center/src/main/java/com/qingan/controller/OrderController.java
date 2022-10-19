package com.qingan.controller;

import com.qingan.domain.Order;
import com.qingan.feign.UserOrderFeign;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qingAn
 * @Date 2022/10/19 1:15
 */
@RestController
public class OrderController implements UserOrderFeign {

    @Override
    public Order getOrderByUserId(Integer userId) {
        System.out.println(userId);
        Order order = Order.builder()
                .name("青椒肉丝")
                .price(15D)
                .orderId(1)
                .build();
        return order;
    }
}
