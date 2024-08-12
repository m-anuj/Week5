package com.example.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.example.aopdemo.aspects.PointCutExpression.forPackageDAOExcludeGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("\n ======> LOGGING TO CLOUD IN ASYNC FASHION");
    }
}
