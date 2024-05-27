package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    //this is where all of our advices for logging are added

    //lets aadd @Before advice
    //@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())") //target object =addaccount- this is pointcut expression
   // @Before("execution(public void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*(com.luv2code.aopdemo.Account))")
   // @Before("execution(* add*(..))")
    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){ //run this code before addaccount

        System.out.println("executing the code @Before advice");
    }
}
