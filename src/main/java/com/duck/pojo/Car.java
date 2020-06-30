package com.duck.pojo;

public class Car {
    private int maxSpeed;
    private String brand;
    private double price;

    public Car(){

    }

    public Car(int maxSpeed, String brand, double price) {
        this.maxSpeed = maxSpeed;
        this.brand = brand;
        this.price = price;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
