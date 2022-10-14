package com.qingan.userservice.feign;

import com.qingan.userservice.admin.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author qingAn
 * @FeignClient(value = "order-service")
 * value就是提供者的应用名称
 * @date 2022/10/10 12:00
 */
@FeignClient("order-service")
public interface UserOrderFeign {

    /**
     * 你需要调用哪个controller 就写它的方法签名
     * 方法签名(就是包含一个方法的所有属性)
     */
    @GetMapping("doOrder")
    String doOrder();

    @GetMapping("testUrl/{name}/{age}")
    String testUrl(@PathVariable("name") String name, @PathVariable("age") Integer age);

    @GetMapping("oneParam")
    String oneParam(@RequestParam(name = "name", required = false) String name);

    @GetMapping("twoParam")
    String twoParam(@RequestParam(name = "name",required = false) String name, @RequestParam(name = "age",required = false) Integer age);

    @PostMapping("oneObj")
    String oneObj(@RequestBody Order order);

    @PostMapping("oneObjOneParam")
    String oneObjOneParam(@RequestBody Order order, @RequestParam(name = "name",required = false) String name);

    @PostMapping("/testTime")
    String testTime(@RequestBody LocalDateTime date);
}
