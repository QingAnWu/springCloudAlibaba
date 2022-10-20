package com.qingan.nacosclienta.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author qingAn
 * @date 2022/10/06 23:30
 */
@FeignClient(value = "nacos-client")
public interface TestFeign {
    @GetMapping("/info")
    String hello();
}
