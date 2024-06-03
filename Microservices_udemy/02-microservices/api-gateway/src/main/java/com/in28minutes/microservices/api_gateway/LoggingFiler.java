package com.in28minutes.microservices.api_gateway;

import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import org.slf4j.Logger;
@Component
public class LoggingFiler implements GlobalFilter {
    private Logger logger= LoggerFactory.getLogger((LoggingFiler.class));
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Path of the request received -> {}",exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
