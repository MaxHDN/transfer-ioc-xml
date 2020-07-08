package com.duck.pojo;

public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("naive waiter greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("naive waiter serving to " + name + "...");
    }
}
