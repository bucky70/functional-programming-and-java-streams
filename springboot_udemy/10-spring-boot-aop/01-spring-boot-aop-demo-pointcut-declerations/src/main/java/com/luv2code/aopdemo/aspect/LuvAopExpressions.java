package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpressions {
    //this is where all of our advices for logging are added
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forReusablilityDAOPackage(){}

    //point cut to execute only for get methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter(){}
    //pointcut to execute only for set methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter(){}

    //pointcut expression logic for allmethods except getter and setter
    @Pointcut("forReusablilityDAOPackage() && !(getter() || setter())")
    private void forDAOPackageNoGetterSetter(){}
}
