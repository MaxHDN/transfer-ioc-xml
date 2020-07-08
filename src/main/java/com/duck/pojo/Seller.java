package com.duck.pojo;

public class Seller implements Waiter{
    @Override
    public void greetTo(String name) {
        System.out.println("Seller greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("Seller serving to " + name + "...");
    }
}
