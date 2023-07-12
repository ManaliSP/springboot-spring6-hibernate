package com.springboot.aspectorientedprogramming.aspect;

import com.springboot.aspectorientedprogramming.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
