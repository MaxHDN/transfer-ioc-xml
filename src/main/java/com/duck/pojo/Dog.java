package com.duck.pojo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog {

    public Dog(){
        System.out.println("Dog Constructor ...");
    }

    @PostConstruct
    public void init(){
        System.out.println("dog init ...");
    }

    @PostConstruct
    public void init1(){
        System.out.println("dog init1 ...");
    }

    public void move(){
        System.out.println("move");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("dog destroy ...");
    }

    @PreDestroy
    public void destroy1(){
        System.out.println("dog destroy1 ...");
    }
}
