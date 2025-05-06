package com.rml.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
@Primary
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkOut() {
        return "Spend 30mn for practice coding";
    }
}
