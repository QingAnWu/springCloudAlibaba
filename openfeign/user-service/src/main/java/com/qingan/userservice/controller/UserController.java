package com.qingan.userservice.controller;

import com.qingan.userservice.admin.Order;
import com.qingan.userservice.feign.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author qingAn
 * @date 2022/10/10 11:21
 */
@RestController
public class UserController {

    @Autowired
    private UserOrderFeign userOrderFeign;

    /**
     * 总结
     * 浏览器（前端）----> user-service(/userDoOrder) -----RPC(feign) ----> order-server(/doOrder)
     * feign的默认等待时间1s
     * 超过一秒就直接报超时
     * @return
     */
    @GetMapping("userDoOrder")
    public String userDaoOrder(){
        System.out.println("用户来了");
        return userOrderFeign.doOrder();
    }

    @GetMapping("testParm")
    public String testParm(){
        String testUrl = userOrderFeign.testUrl("貂蝉", 18);
        System.out.println("testUrl = " + testUrl);

        String oneParam = userOrderFeign.oneParam("吕布");
        System.out.println("oneParam = " + oneParam);

        String twoParam = userOrderFeign.twoParam("嫦娥", 18);
        System.out.println("twoParam = " + twoParam);

        Order order = Order.builder()
                .id(1)
                .name("小乔")
                .price(188D)
                .time(LocalDateTime.now())
                .build();
        String oneObj = userOrderFeign.oneObj(order);
        System.out.println("oneObj = " + oneObj);

        String oneObjOneParam = userOrderFeign.oneObjOneParam(order, "鸡哥");
        System.out.println("oneObjOneParam = " + oneObjOneParam);

        return "ok";
    }

    @PostMapping("time")
    private String testTime() {
        System.out.println(LocalDateTime.now());
        userOrderFeign.testTime(LocalDateTime.now());
        return "ok";
    }

}
