package com.duck.proxy;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class GreetingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object object, Method method, Object[] args, Object o1) throws Throwable {
        System.out.println("pleas enjoy yourself !");
    }
}
