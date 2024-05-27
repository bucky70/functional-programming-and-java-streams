package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.TrackCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach coach,@Qualifier("cricketCoach") Coach anotherCoach){
        System.out.println("In classs of:"+ getClass().getSimpleName());
        this.myCoach=coach;
        this.anotherCoach=anotherCoach;

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "comparing beans: coach==anotherCoach, "+(myCoach==anotherCoach);
    }
}
