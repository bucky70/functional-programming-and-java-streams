package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("In classs of:"+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "workout tennis related workouts";
    }
}
