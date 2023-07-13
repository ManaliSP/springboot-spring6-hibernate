package com.springboot.aspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.springboot.aspectorientedprogramming.aspect.AopPointcutExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){

        System.out.println("\n=====> Performing API Analysis");
    }
}
