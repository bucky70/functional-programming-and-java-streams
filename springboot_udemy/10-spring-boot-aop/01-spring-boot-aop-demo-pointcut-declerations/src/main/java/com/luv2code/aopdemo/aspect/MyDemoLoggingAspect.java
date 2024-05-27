package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect{



    //@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
    //@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){ //run this code before addaccount
        System.out.println("executing the code @Before advice");
    }


}
