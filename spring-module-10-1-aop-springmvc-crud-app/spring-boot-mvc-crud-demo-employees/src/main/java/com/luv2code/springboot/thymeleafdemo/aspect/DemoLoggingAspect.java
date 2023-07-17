package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    // do same for service and dao
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    // combine pointcuts
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    // add before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){

        // display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("=====>>>> in @Before: calling method: " + method);

        // display the arguments to the method

        // get the arguments
        Object args[] = joinPoint.getArgs();

        // loop through and display args
        for(Object obj : args){
            logger.info("====>>>> arguments: " + obj);
        }
    }
}
