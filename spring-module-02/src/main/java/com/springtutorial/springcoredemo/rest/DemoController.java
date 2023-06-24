package com.springtutorial.springcoredemo.rest;

import com.springtutorial.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for dependency
    private Coach myCoach;
    private Coach anotherCoach;

    //Constructor injection
//    @Autowired
//    public DemoController(Coach theCoach){
//        myCoach = theCoach;
//    }

      //Constructor injection using Qualifiers
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theAnotherCoach){
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

      //Setter Injection
//    @Autowired
//    public void setCoach(Coach theCoach) {
//        myCoach = theCoach;
//    }

      //Field Injection
//    @Autowired
//    private Coach fieldCoach;

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/checkbeanscope")
    public String checkBeanSCope(){
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
