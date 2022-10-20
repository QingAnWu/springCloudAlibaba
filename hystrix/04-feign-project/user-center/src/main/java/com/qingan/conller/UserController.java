package com.qingan.conller;

import com.qingan.domain.Order;
import com.qingan.feign.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qingAn
 * @Date 2022/10/19 20:15
 */
@RestController
public class UserController {
    @Autowired
    private UserOrderFeign userOrderFeign;

    @GetMapping("find")
    public Order finOrder(){
        return userOrderFeign.getOrderByUserId(1);
    }

}
