package com.in28minutes.rest.webservices.restful_web_services.controller;

import com.in28minutes.rest.webservices.restful_web_services.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource){
        this.messageSource=messageSource;
    }
   @RequestMapping(method= RequestMethod.GET,path = "hello-world")
    public String helloWorld(){
       return "HelloWorld";
   }

    @RequestMapping(method= RequestMethod.GET,path = "hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello world");
    }

    @RequestMapping(method= RequestMethod.GET,path = "hello-world-bean/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name){
        return new HelloWorldBean("Hello world "+ name);
    }
    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(){
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
       //return "hello world v2";
    }
}
