package com.springboot.aspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

    // this is where we add our related advices for logging

    // let's start with @Before aspect

    // pointcut expression - match on method name in any class
//    @Before("execution(public void addAccount())")

    // pointcut expression - match on method name in specific class/interface
//    @Before("execution(public void  com.springboot.aspectorientedprogramming.dao.AccountDAO.addAccount())")

    // pointcut expression - match on method name any add*
//    @Before("execution(public void add*())")

    // pointcut expression - match method with bases on return type
//    @Before("execution(void add*())")

    // pointcut expression - match method with any return type
    @Before("execution(* add*())")
    public void beforeAddAccountAdvice(){

        System.out.println("\n=====> Executing @Before advice on addAccount()");
    }

}
