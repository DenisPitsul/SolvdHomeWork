package com.solvd.homework.hw2.model;

import com.solvd.homework.hw2.model.interfaces.ICarModel;

public class MercedesVito extends MiniBus implements ICarModel {
    private int passengerSeatsCount;

    public MercedesVito(int maxSpeed, int year) {
        super("Desel 2.2", maxSpeed, year);
        setPassenger(true);
        setThereBackWindows(true);
    }

    public MercedesVito() {
    }

    public int getPassengerSeatsCount() {
        return passengerSeatsCount;
    }

    public void setPassengerSeatsCount(int passengerSeatsCount) {
        this.passengerSeatsCount = passengerSeatsCount;
    }

    @Override
    public String toString() {
        return "MercedesVito{" +
                "model='" + carModel() + '\'' +
                ", engine='" + getEngine() + '\'' +
                ", color='" + getColor() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", isPassenger=" + isPassenger() +
                ", isThereBackWindows=" + isThereBackWindows() +
                ", passengerSeatsCount=" + passengerSeatsCount +
                '}';
    }

    @Override
    public String carModel() {
        String className = this.getClass().getName();
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
