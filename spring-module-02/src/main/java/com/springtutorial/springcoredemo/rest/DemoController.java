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

    //Constructor injection
//    @Autowired
//    public DemoController(Coach theCoach){
//        myCoach = theCoach;
//    }

    //Setter Injection
//    @Autowired
//    public void setCoach(Coach theCoach) {
//        myCoach = theCoach;
//    }

    //Field Injection
//    @Autowired
//    private Coach fieldCoach;


    //Constructor injection using Qualifiers
//    @Autowired
//    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
//        System.out.println("In constructor: " + getClass().getSimpleName());
//        myCoach = theCoach;
//    }


    //Check bean scopes
//      private Coach anotherCoach;
//    @Autowired
//    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
//                          @Qualifier("cricketCoach") Coach theAnotherCoach){
//        myCoach = theCoach;
//        anotherCoach = theAnotherCoach;
//    }
//      @GetMapping("/checkbeanscope")
//    public String checkBeanSCope(){
//        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
//    }

    //Bean injection using Qualifiers
    //@Qualifier("aquatic") - using bean id
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
