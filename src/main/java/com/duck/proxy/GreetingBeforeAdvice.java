package com.duck.proxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object object) throws Throwable {
        String clientName = (String)args[0];
        System.out.println("How are you ! Mr." + clientName + ".");
    }

}
