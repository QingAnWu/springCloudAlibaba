package com.qingan.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author qingAn
 * @Date 2022/10/19 0:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private Integer orderId;
    private String name;
    private Double price;

}
