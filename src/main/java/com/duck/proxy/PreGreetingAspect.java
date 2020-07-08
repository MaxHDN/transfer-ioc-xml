package com.duck.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//通过该注解将PreGreetingAspect标识为一个切面
@Aspect
public class PreGreetingAspect {

    // 定义切点和增强类型
    @Before("execution(* greetTo(..))")
    public void beforeGreeting(){ //增强的横切逻辑
        System.out.println("How are you ! ");
    }
}
