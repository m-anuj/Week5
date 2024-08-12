package com.example.aopdemo.aspects;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //Adding around advice
    @Around("execution(* com.example.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
        //Print out which method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @Around on method: "+method);

        //get Begin timeStamp
        long begin = System.currentTimeMillis();

        //now Lets excute the method
        Object result = theProceedingJoinPoint.proceed();

        //get end timeStamp
        long end = System.currentTimeMillis();

        //compute duration and display it
        long duration = end - begin;

        System.out.println("\n======>Duration :"+duration/1000.0+" seconds");

        return result;
    }

    //Adding after advice
    @After("execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJointPoint){

        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @After (finally) on method: "+method);


    }

    //Adding after throwing advice
    @AfterThrowing(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint theJointPoint, Throwable theExc){
        //Print out which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterThrowing on method: "+method);

        //print out the result of the method calls
        System.out.println("\n=======>> The exception is: "+theExc);
    }

    //Adding after returning advice
    @AfterReturning(
            pointcut = "execution(* com.example.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJointPoint, List<Account> result){

        //Print out which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterReturning on method: "+method);

        //print out the result of the method calls
        System.out.println("\n=======>> result is: "+result);

        //Post processing the data

        convertAccountNamesToUpperCase(result);

        System.out.println("\n=======>> Modified result is: "+result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through account

        for(Account tempAccount:result){
            //get the accountName
            String theUpperName = tempAccount.getName().toUpperCase();

            //update the name on the Account
            tempAccount.setName(theUpperName);

        }
    }

    @Before("com.example.aopdemo.aspects.PointCutExpression.forPackageDAOExcludeGetterSetter()")
    public void beforeAddAccount(JoinPoint theJointPoint){
        System.out.println("\n ======> Executing @Before advice on method");

        //Display the Method signature
        MethodSignature methodSignature = (MethodSignature) theJointPoint.getSignature();
        System.out.println(methodSignature);

        //Get ARGS
        Object[] args = theJointPoint.getArgs();

        for(Object tempArg:args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                Account account = (Account) tempArg;
                System.out.println("Account Name: "+account.getName());
                System.out.println("Account Level: "+account.getLevel());
            }
        }

    }

}
