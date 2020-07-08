package com.duck.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Boss {
    private String name;
    private Car car;
    private List<House> houseList;
    private Set<Child> children;
    private Map<Object,Object> jobs;
    private Properties mails;
    private Map<String,Integer> jobTime;

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

    public void setChildren(Set<Child> children) {
        this.children = children;
    }

    public void setJobs(Map<Object, Object> jobs) {
        this.jobs = jobs;
    }

    public void setMails(Properties mails) {
        this.mails = mails;
    }

    public void setJobTime(Map<String, Integer> jobTime) {
        this.jobTime = jobTime;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", houseList=" + houseList +
                ", children=" + children +
                ", jobs=" + jobs +
                ", mails=" + mails +
                ", jobTime=" + jobTime +
                '}';
    }
}
