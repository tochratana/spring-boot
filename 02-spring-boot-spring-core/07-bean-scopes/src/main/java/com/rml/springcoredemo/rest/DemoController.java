package com.rml.springcoredemo.rest;

import com.rml.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // defined private for the dependency
    private Coach mycoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("baseballCoach") Coach theCoach,
            @Qualifier("baseballCoach") Coach theAnotherCoach){
        System.out.println("Instructor : " + getClass().getName());
        mycoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkOut();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans scopes : " + (mycoach == anotherCoach);
    }
}
