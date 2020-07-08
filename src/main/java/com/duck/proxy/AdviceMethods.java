package com.duck.proxy;

import org.aspectj.lang.JoinPoint;

public class AdviceMethods {

    public void preGreeting(JoinPoint joinPoint){
        System.out.println("How are you ! ");
        System.out.println(joinPoint.getArgs().toString());
    }

    public void afterReturning(){
        System.out.println("serving done ...");
    }
}
