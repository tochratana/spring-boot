package com.rml.springcoredemo.common;

import org.springframework.stereotype.Component;
@Component
public class BaseballCoach implements Coach {
    public BaseballCoach (){
        System.out.println("Instructor : " + getClass().getName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Spend 30mn for practice coding";
    }
}
