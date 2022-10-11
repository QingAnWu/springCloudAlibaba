package com.qingan.userservice.controller;

import com.qingan.userservice.feign.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
