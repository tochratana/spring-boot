package com.rml.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
// This class is implement from interface, and overried method, this we call method overrieding

public class CricketCoach implements Coach{

    // Override method and then add body to this method
    @Override
    public String getDailyWorkOut() {
        return "Practice Fast :-)";
    }
}
