package com.solvd.cars.cars;

public class MiniBus extends Car {
    private boolean isPassenger;
    private boolean isThereBackWindows;

    public MiniBus(String engine, String color, String number, int maxSpeed, int year,
                   boolean isPassenger, boolean isThereBackWindows) {
        super(engine, color, number, maxSpeed, year);
        this.isPassenger = isPassenger;
        this.isThereBackWindows = isThereBackWindows;
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

    public void setThereBackWindows(boolean thereBackWindows) {
        isThereBackWindows = thereBackWindows;
    }

    @Override
    public String toString() {
        return "MiniBus{" +
                "engine='" + getEngine() +
                ", color='" + getColor() +
                ", number='" + getNumber() +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", isPassenger=" + isPassenger +
                ", isThereBackWindows=" + isThereBackWindows +
                '}';
    }
}
