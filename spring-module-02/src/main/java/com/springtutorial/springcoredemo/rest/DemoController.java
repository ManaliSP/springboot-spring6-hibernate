package com.springtutorial.springcoredemo.rest;

import com.springtutorial.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for dependency
    private Coach myCoach;

    //Constructor injection
//    @Autowired
//    public DemoController(Coach theCoach){
//        myCoach = theCoach;
//    }

    //Setter Injection
    @Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }

    //Field Injection
    @Autowired
    private Coach coach;
    
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
