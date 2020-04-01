package com.solvd.homework.car_class_hierarchy.model.vehicle;

public class Truck extends Car {
    private int liftingCapacity; // tons

    public Truck(String engine, int maxSpeed, int year) {
        super(engine, maxSpeed, year);
    }

    public Truck(String engine, String color, String number, int maxSpeed, int year, int liftingCapacity) {
        super(engine, color, number, maxSpeed, year);
        this.liftingCapacity = liftingCapacity;
    }

    public Truck() {
    }

    public int getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(int liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "engine='" + getEngine() + '\'' +
                ", color='" + getColor() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", liftingCapacity=" + liftingCapacity +
                '}';
    }


}
