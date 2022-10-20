package com.qingan.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author qingAn
 * @Date 2022/10/20 17:54
 */
@Order(-2)
@Component
public class IPCheckFilter implements GlobalFilter {

    /**
     * 网关的并发量比较高 不要再网关里面操作mysql
     * 后台系统可以查询数据库 用户量 并发量不大
     * 如果并发量大 可以查redis 或者在内存中写好
     */
    public static final List<String> BLACK_LIST= Arrays.asList("127.0.0.1","144.128.232.147");


    @Override

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String ip = request.getHeaders().getHost().getHostString();
        //查询数据库 看这个ip是否存在黑名单里面
        if (!BLACK_LIST.contains(ip)){
            return chain.filter(exchange);
        }
        //拦截
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().set("content-type","application/json;charset=utf-8");
        HashMap<String, Object> map = new HashMap<>(4);
        map.put("code",438);
        map.put("msg","黑名单");
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytes =new byte[0];
        try {
            bytes = objectMapper.writeValueAsBytes(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        DataBuffer wrap = response.bufferFactory().wrap(bytes);
        return response.writeWith(Mono.just(wrap));
    }
}
