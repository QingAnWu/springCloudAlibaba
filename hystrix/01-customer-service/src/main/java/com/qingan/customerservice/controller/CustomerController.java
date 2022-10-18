package com.qingan.customerservice.controller;

import com.qingan.customerservice.feign.CustomerRentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qingAn
 * @date 2022/10/15 14:33
 */
@RestController
public class CustomerController {


    @Autowired
    private CustomerRentFeign customerRentFeign;

    @GetMapping("customerRent")
    public String test() {
        return customerRentFeign.rent();
    }
}
