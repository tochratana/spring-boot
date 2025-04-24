package com.luv2code.spring.demo.__spring_boot_overview.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that return "Hello World"
    @GetMapping
    public String sayHello(){
        return "Hello World, this is my code, this project you can implement some of configuration!";
    }

}

