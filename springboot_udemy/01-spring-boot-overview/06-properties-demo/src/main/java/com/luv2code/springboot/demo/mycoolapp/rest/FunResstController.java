package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunResstController {
    //inject properties for coach and team name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    //expose endpoint for team info
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "coach: "+ coachName + " team: "+ teamName;
    }
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
