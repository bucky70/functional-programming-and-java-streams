package com.in28minutes.microservices.currency_exchange_service.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
   // @Retry(name="sample-api", fallbackMethod="hardCodedResponse") //retried 3 time and return error
    //@CircuitBreaker(name="default", fallbackMethod = "hardCodedResponse")
   // @RateLimiter(name="default") //only 100 requests per second
    @Bulkhead(name="default")
    public String sampleApi(){
        logger.info("sample api call received");
       // ResponseEntity<String> forEntity=new RestTemplate().getForEntity("http://localhost:9090/somedumme-url",String.class);
       // return forEntity.getBody();
        return "sample api";
    }
    public String hardCodedResponse(Exception e){
        return "hard coded response";
    }
}
