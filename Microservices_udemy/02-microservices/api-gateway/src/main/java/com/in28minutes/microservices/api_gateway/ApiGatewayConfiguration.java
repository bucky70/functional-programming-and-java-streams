package com.in28minutes.microservices.api_gateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        Function<PredicateSpec, Buildable<Route>> routeFunction
                =p->p.path("/get")
                .filters(f ->
                        f.addRequestHeader("MyHeader","MyURI")
                         .addRequestParameter("Param","MyValue"))
                .uri("http://httpbin.org:80"); //redirecting to this uri if we go to "/get"
        return  builder.routes()
                .route(routeFunction)  //adding route function
                .route(p->p.path("/currency-exchange/**")
                           .uri("lb://currency-exchange"))//load balancing and redirecting
                .route(p->p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))//load balancing and redirecting
                .route(p->p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))//load balancing and redirecting
                .route(p->p.path("/currency-conversion-new/**")
                        .filters(f->f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)",
                                      "/currency-conversion-new/${segment}"))
                        .uri("lb://currency-conversion"))//load balancing and redirecting

                .build();
    }


}
