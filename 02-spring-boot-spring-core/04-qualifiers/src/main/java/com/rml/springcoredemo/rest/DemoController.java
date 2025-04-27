package com.rml.springcoredemo.rest;

import com.rml.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // defined private for the dependency
    private Coach mycoach;

    @Autowired
    public void soSomeStuff(Coach theCoach){
        mycoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return mycoach.getDailyWorkOut();
    }
}
