package com.solvd.homework.hw2.model;

public class Sedan extends Car {
    private int wheelRadius;

    public Sedan(String engine, int maxSpeed, int year) {
        super(engine, maxSpeed, year);
    }

    public Sedan() {
    }

    public int getWheelRadius() {
        return wheelRadius;
    }

    public void setWheelRadius(int wheelRadius) {
        this.wheelRadius = wheelRadius;
    }

    @Override
    public String toString() {
        return "Sedan{" +
                "engine='" + getEngine() + '\'' +
                ", color='" + getColor() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", wheelRadius=" + wheelRadius +
                '}';
    }
}
