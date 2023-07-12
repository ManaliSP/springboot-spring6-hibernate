package com.springboot.aspectorientedprogramming.aspect;

import com.springboot.aspectorientedprogramming.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

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

    @Around("execution(* com.springboot.aspectorientedprogramming.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out which method we are advising on
        // print out which method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = proceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n====>>> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.springboot.aspectorientedprogramming.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (Finally) on method: " + method);


    }

    @AfterThrowing(
            pointcut = "execution(* com.springboot.aspectorientedprogramming.dao.AccountDAO.findAccounts(..))",
            throwing = "caughtException")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable caughtException){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> Exception is: " + caughtException);
    }

    // add new advice for @AfterReturning on the findAccount method
    @AfterReturning(
            pointcut = "execution(* com.springboot.aspectorientedprogramming.dao.AccountDAO.findAccounts(..))",
            returning = "accounts")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n=====>>> Accounts are: " + accounts);

        // lets post-process the data ... lets modify it :-)
        // convert the account names to uppercase
        convertAccountNamesToUpperCase(accounts);

        // print out the results of the method call
        System.out.println("\n=====>>> Uppercase Accounts are: " + accounts);
    }

    private void convertAccountNamesToUpperCase(List<Account> accounts) {

        // loop through accounts
        for(Account account : accounts){
            // get uppercase version of account name
            String uppercaseName = account.getName().toUpperCase();

            // update the name on account
            account.setName(uppercaseName);
        }
    }

    // Use pointcut declaration
    @Before("com.springboot.aspectorientedprogramming.aspect.AopPointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){

      System.out.println("\n=====> Executing @Before advice on addAccount()");

      // display the method signature
      MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
      System.out.println("Method: " + methodSignature);

      // display method arguments

      // get args
      Object[] args = joinPoint.getArgs();

      // loop through args
      for(Object tempArgs : args){
        System.out.println(tempArgs);

        if(tempArgs instanceof Account){

          // downcast and point Account specific stuff
          Account account = (Account) tempArgs;

          System.out.println("Account name: " + account.getName());
          System.out.println("Account level: " + account.getLevel());
        }
      }
    }
}
