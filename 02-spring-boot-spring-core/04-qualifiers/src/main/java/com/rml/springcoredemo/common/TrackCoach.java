package com.rml.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Run hard 5km!";
    }
}
