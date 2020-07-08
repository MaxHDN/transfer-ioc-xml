package com.duck.proxy;

import com.duck.pojo.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPoincut extends DynamicMethodMatcherPointcut {

    private static List<String> specialClientList = new ArrayList<>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    public ClassFilter getClassFilter(){
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                System.out.println("调用getClassFilter()对" + aClass.getName() + "."  + "做静态检查。");
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }

    public boolean matches(Method method, Class<?> aClass) {
        System.out.println("调用matches(method,aClass)" + aClass.getName() + "." + method.getName() + "做静态检查。");
        return "greetTo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... args) {
        System.out.println("调用matches(method,aClass)" + aClass.getName() + "." + method.getName() + "做动态检查。");
        String clientName = (String) args[0];
        return specialClientList.contains(clientName);
    }
}
