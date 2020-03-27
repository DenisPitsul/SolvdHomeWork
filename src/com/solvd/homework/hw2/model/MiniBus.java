package com.solvd.homework.hw2.model;

public class MiniBus extends Car {
    private boolean isPassenger;
    private boolean isThereBackWindows;

    public MiniBus(String engine, int maxSpeed, int year) {
        super(engine, maxSpeed, year);
    }

    public MiniBus() {
    }

    public boolean isPassenger() {
        return isPassenger;
    }

    public void setPassenger(boolean passenger) {
        isPassenger = passenger;
    }

    public boolean isThereBackWindows() {
        return isThereBackWindows;
    }

    public void setThereBackWindows(boolean isThereBackWindows) {
        this.isThereBackWindows = isThereBackWindows;
    }

    @Override
    public String toString() {
        return "MiniBus{" +
                "engine='" + getEngine() + '\'' +
                ", color='" + getColor() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", isPassenger=" + isPassenger +
                ", isThereBackWindows=" + isThereBackWindows +
                '}';
    }
}
