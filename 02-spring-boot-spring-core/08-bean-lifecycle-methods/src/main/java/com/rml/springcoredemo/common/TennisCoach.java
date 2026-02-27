package com.rml.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach  implements Coach{

    public TennisCoach (){
        System.out.println("Instructor : " + getClass().getName());
    }

    @Override
    public String getDailyWorkOut() {
        return "Love you so much";
    }
}
