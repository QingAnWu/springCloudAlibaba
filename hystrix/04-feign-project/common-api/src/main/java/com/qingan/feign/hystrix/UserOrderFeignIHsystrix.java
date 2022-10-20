package com.qingan.feign.hystrix;

import com.qingan.domain.Order;
import com.qingan.feign.UserOrderFeign;
import org.springframework.stereotype.Component;

/**
 * @Author qingAn
 * @Date 2022/10/19 20:24
 */
@Component
public class UserOrderFeignIHsystrix implements UserOrderFeign {

    @Override
    public Order getOrderByUserId(Integer userId) {
        return null;
    }
}
