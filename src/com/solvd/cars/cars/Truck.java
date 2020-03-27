package com.solvd.cars.cars;

public class Truck extends Car {
    private int liftingCapacity; // tons

    public Truck(String engine, int maxSpeed, int year) {
        super(engine, maxSpeed, year);
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
