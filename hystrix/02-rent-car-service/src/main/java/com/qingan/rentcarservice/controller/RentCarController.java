package com.qingan.rentcarservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qingAn
 * @date 2022/10/15 12:00
 */
@RestController
public class RentCarController {

    @RequestMapping(value = "rent",method = RequestMethod.GET)
    public String rent(){
        return "租车成功";
    }
}
