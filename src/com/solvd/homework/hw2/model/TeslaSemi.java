package com.solvd.homework.hw2.model;

import com.solvd.homework.hw2.model.interfaces.ICarModel;

public class TeslaSemi extends Truck implements ICarModel {
    private int batteryPowerReserve; // battery power in kilometers of autonomous driving

    public TeslaSemi(int maxSpeed, int year) {
        super("Eleсtro", maxSpeed, year);
    }

    public TeslaSemi() {
    }

    public int getBatteryPowerReserve() {
        return batteryPowerReserve;
    }

    public void setBatteryPowerReserve(int batteryPowerReserve) {
        this.batteryPowerReserve = batteryPowerReserve;
    }

    @Override
    public String toString() {
        return "TeslaSemi{" +
                "model='" + carModel() + '\'' +
                ", engine='" + getEngine() + '\'' +
                ", color='" + getColor() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", liftingCapacity=" + getLiftingCapacity() +
                ", batteryPowerReserve=" + batteryPowerReserve +
                '}';
    }

    @Override
    public String carModel() {
        String className = this.getClass().getName();
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
