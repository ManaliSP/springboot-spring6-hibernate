package com.springboot.tutorial.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {


    //expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }

    //expose "/workout" that returns "Run hard a 5k!!!!"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run hard a 5k!!!!";
    }

    //expose a new endpoint "/fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!!!";
    }
}
