package com.qingan.customerservice.feign;

import com.qingan.customerservice.feign.hystix.CutomerRentFeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * 这里需要指定我们垄断的类
 * @author qingAn
 * @date 2022/10/15 14:35
 */
@FeignClient(value = "rent-car-service",fallback = CutomerRentFeignHystrix.class)
public interface CustomerRentFeign {

    @RequestMapping(value = "rent", method = RequestMethod.GET)
    String rent();
}
