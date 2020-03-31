package com.solvd.homework.hw2.model;

import com.solvd.homework.hw2.model.interfaces.CarModel;

public class TeslaSemi extends Truck implements CarModel {
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
                "model='" + getCarModel() + '\'' +
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
    public String getCarModel() {
        String className = this.getClass().getName();
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
