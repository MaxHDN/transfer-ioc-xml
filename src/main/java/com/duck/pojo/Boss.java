package com.duck.pojo;

import java.util.List;

public class Boss {
    private String name;
    private Car car;
    private List<House> houseList;

    public Boss(){

    }
    public Boss(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public Boss(String name, Car car, List<House> houseList) {
        this.name = name;
        this.car = car;
        this.houseList = houseList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setHouseList(List<House> houseList) {
        this.houseList = houseList;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
