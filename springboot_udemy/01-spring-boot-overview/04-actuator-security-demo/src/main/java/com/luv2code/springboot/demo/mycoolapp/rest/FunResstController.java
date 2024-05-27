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

    //expose new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "run a hard 5k";
    }
    //new endpoiunt for fortune
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "today is your lucky day";
    }
}
