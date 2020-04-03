package com.solvd.homework.car_class_hierarchy.model.vehicle;

public abstract class Vehicle {
    private Engine engine;

    public Vehicle(Engine engine) {
        this.engine = engine;
    }

    public Vehicle() {
    }

    public String getEngine() {
        return engine.getName();
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public abstract void honk();

}
