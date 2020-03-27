package com.solvd.homework.hw2.model;

public class Vehicle {
    private String engine;

    public Vehicle(String engine) {
        this.engine = engine;
    }

    public Vehicle() {
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "engine='" + engine + '\'' +
                '}';
    }
}
