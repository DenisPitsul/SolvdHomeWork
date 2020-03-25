package com.solvd.cars.cars;

public class Sedan extends Car {
    private int wheelRadius;

    public Sedan(String engine, String color, String number, int maxSpeed, int year, int wheelRadius) {
        super(engine, color, number, maxSpeed, year);
        this.wheelRadius = wheelRadius;
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
                "engine='" + getEngine() +
                ", color='" + getColor() +
                ", number='" + getNumber() +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", wheelRadius=" + wheelRadius +
                '}';
    }
}
