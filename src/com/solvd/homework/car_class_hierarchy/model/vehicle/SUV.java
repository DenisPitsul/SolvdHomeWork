package com.solvd.homework.car_class_hierarchy.model.vehicle;

public class SUV extends Car {
    private boolean isThereTopTrunk;
    private int clearanceLength;

    public SUV(String engine, int maxSpeed, int year) {
        super(engine, maxSpeed, year);
    }

    public SUV(String engine, String color, String number, int maxSpeed, int year, boolean isThereTopTrunk, int clearanceLength) {
        super(engine, color, number, maxSpeed, year);
        this.isThereTopTrunk = isThereTopTrunk;
        this.clearanceLength = clearanceLength;
    }

    public SUV() {
    }

    public boolean isThereTopTrunk() {
        return isThereTopTrunk;
    }

    public void setThereTopTrunk(boolean isThereTopTrunk) {
        this.isThereTopTrunk = isThereTopTrunk;
    }

    public int getClearanceLength() {
        return clearanceLength;
    }

    public void setClearanceLength(int clearanceLength) {
        this.clearanceLength = clearanceLength;
    }

    @Override
    public String toString() {
        return "SUV{" +
                "engine='" + getEngine() + '\'' +
                ", color='" + getColor() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", isThereTopTrunk=" + isThereTopTrunk +
                ", clearanceLength=" + clearanceLength +
                '}';
    }
}
