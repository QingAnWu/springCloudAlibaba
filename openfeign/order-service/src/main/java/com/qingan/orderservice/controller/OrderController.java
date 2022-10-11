package com.qingan.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qingAn
 * @date 2022/10/10 11:09
 */
@RestController
public class OrderController {

    @GetMapping("doOrder")
    public String doOrder(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "油条豆浆-热干面";
    }
}
