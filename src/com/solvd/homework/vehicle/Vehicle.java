package com.solvd.homework.vehicle;

import com.solvd.homework.vehicle.helper.Engine;

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

    public abstract String getShortInfo();

    public abstract String getCarModel();

}
