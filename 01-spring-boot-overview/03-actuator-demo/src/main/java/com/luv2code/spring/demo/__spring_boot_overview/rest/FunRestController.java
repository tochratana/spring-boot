package com.luv2code.spring.demo.__spring_boot_overview.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World, this is my code, this project you can implement some of configuration!fdfsdds";
    }

    // expose a new endpoint fow "workout"
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Get Daily work out";
    }

    // expose a new endpoint fow "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }


    // expose a new endpoint fow "today"
    @GetMapping("/today")
    public String getDailyToday(){
        return "Today you so cute!";
    }

    // expose a new endpoint fow "developer"
    @GetMapping("/developer")
    public String getDailyDeveloper(){
        return "Hey developer!";
    }

    // expose a new endpoint fow "you"
    @GetMapping("/you")
    public String getDailyYou(){
        return "Love you!";
    }

    // expose a new endpoint fow "me"
    @GetMapping("/me")
    public String getDailyMe(){
        return "Do you love me";
    }


}

