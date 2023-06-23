package com.springboot.tutorial.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    //Injecting custom application.properties in app
    @Value("${developer.name}")
    private String developerName;

    @Value("${developer.position}")
    private String  developerPosition;

    //Expose new endpoint for developer info
    @GetMapping("/developerinfo")
    public String getDeveloperInfo(){
        return "Developer is " + developerName + " and her position in organization is " + developerPosition + ".";
    }

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
