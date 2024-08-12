package com.example.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all the related advice before logging

    @Before("execution(* com.example.aopdemo.dao.*.*(..))")
    public void beforeAddAccount(){
        System.out.println("\n ======> Executing @Before advice on method");
    }

}
