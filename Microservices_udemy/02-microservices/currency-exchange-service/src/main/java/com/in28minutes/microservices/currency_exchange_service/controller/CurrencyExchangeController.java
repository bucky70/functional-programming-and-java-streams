package com.in28minutes.microservices.currency_exchange_service.controller;

import com.in28minutes.microservices.currency_exchange_service.entity.CurrencyExchange;
import com.in28minutes.microservices.currency_exchange_service.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchange(@PathVariable String from, @PathVariable String to){
      //  CurrencyExchange currencyExchange=new CurrencyExchange(1000L,from,to, BigDecimal.valueOf(50));
        CurrencyExchange currencyExchange=currencyExchangeRepository.findByFromAndTo(from,to);
        if(currencyExchange==null){
            throw new RuntimeException("unable to find data for "+from+" to "+to);
        }

        String port=environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port); //self instance/environment port
        return currencyExchange;
    }
}
