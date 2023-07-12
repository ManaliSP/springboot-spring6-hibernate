package com.springboot.aspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

    // this is where we add our related advices for logging

    // let's start with @Before aspect

/*
Pointcut expressions exmaples for reference

    pointcut expression - match on method name in any class
    @Before("execution(public void addAccount())")

     pointcut expression - match on method name in specific class/interface
    @Before("execution(public void  com.springboot.aspectorientedprogramming.dao.AccountDAO.addAccount())")

     pointcut expression - match on method name any add*
    @Before("execution(public void add*())")

     pointcut expression - match method with bases on return type
    @Before("execution(void add*())")

     pointcut expression - match method with any return type
    @Before("execution(* add*())")

     pointcut expression - match method on method parameters

     match method on Account parameters
    @Before("execution(* add*(com.springboot.aspectorientedprogramming.Account))")

     match method on more parameters
    @Before("execution(* add*(com.springboot.aspectorientedprogramming.Account, ..))")

     pointcut expression - match method on any parameters
    @Before("execution(* add*(..))")

     pointcut expression - match method in a package
    @Before("execution(* com.springboot.aspectorientedprogramming.dao.*.*(..))")
*/

  // Pointcut declaration
    @Pointcut("execution(* com.springboot.aspectorientedprogramming.dao.*.*(..))")
    private void forDaoPackage() {}

  // Use pointcut declaration
  @Before("forDaoPackage()")
  public void beforeAddAccountAdvice(){

      System.out.println("\n=====> Executing @Before advice on addAccount()");
  }

  @Before("forDaoPackage()")
  public void performApiAnalytics(){

      System.out.println("\n=====> Performing API Analysis");
  }
}
