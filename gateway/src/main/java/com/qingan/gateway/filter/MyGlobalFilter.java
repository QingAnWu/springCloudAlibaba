package com.qingan.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author qingAn
 * @Date 2022/10/20 15:53
 */
@Order(-1)
@Component
public class MyGlobalFilter implements GlobalFilter {

    /**
     *  这个就是过滤的方法
     *  过滤器链模式
     *  责任链模式
     *
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //HttpServletRequest 这个是web里面的
        //ServerHttpRequest  webFlux里面 响应式里面的
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String path = request.getURI().getPath();
        System.out.println(path);

        MultiValueMap<String, String> queryParams = request.getQueryParams();
        System.out.println(queryParams);
        //放行到下一个过滤器
        return chain.filter(exchange);
    }
}
