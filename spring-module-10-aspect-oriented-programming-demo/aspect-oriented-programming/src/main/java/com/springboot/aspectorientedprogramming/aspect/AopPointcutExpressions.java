package com.springboot.aspectorientedprogramming.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointcutExpressions {

    // Pointcut declaration
    @Pointcut("execution(* com.springboot.aspectorientedprogramming.dao.*.*(..))")
    public void forDaoPackage() {}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.springboot.aspectorientedprogramming.dao.*.get*(..))")
    public void getter(){}

    //create a pointcut for setter methods
    @Pointcut("execution(* com.springboot.aspectorientedprogramming.dao.*.set*(..))")
    public void setter(){}

    // create pointcut: include/combine package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
