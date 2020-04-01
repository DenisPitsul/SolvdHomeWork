package com.solvd.homework.car_class_hierarchy.model.vehicle;

public abstract class Vehicle {
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

    public abstract void honk();

}
