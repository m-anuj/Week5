package com.example.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.example.aopdemo.aspects.PointCutExpression.forPackageDAOExcludeGetterSetter()")
    public void performingAPIAnalysis(){
        System.out.println("\n ======> PERFORMING API ANALYSIS");
    }
}
