package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunResstController {
    //expose '/' endpoint
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
}
