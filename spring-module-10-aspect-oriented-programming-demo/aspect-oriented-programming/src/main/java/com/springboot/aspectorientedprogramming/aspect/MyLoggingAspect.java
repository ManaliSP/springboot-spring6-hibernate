package com.springboot.aspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

    // this is where we add our related advices for logging

    // let's start with @Before aspect

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){

        System.out.println("\n=====> Executing @Before advice on addAccount()");
    }

}
