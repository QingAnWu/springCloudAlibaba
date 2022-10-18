package com.qingan.customerservice.feign.hystix;

import com.qingan.customerservice.feign.CustomerRentFeign;
import org.springframework.stereotype.Component;

/**
 * @author qingAn
 * @date 2022/10/15 15:06
 */
@Component
public class CutomerRentFeignHystrix implements CustomerRentFeign {
    /**
     * 这个方法是备选方案
     * @return
     */
    @Override
    public String rent() {
        return "我是备胎";
    }
}
