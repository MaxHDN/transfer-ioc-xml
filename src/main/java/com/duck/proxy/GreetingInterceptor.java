package com.duck.proxy;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        String clientName = (String)args[0];
        System.out.println("环绕，方法前" + clientName + "...");
        Object obj = invocation.proceed();
        System.out.println("环绕，方法后" + clientName + ".");
        return obj;
    }
}
