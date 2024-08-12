package com.example.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutExpression {
    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    public void forPackageDAO(){}

    //creating a pointcut for getter method
    @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
    public void getter(){}

    //creating a pointcut for setter method
    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    public void setter(){}

    //creating a pointcut for package method exclude getter/setter
    @Pointcut("forPackageDAO() && !(getter() || setter())")
    public void forPackageDAOExcludeGetterSetter(){}
}
