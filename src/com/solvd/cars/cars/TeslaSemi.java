package com.solvd.cars.cars;

public class TeslaSemi extends Truck {
    private int batteryPowerReserve; // battery power in kilometers of autonomous driving

    public TeslaSemi(String color, String number, int maxSpeed, int year,
                     int liftingCapacity, int batteryPowerReserve) {
        super("Eleсtro", color, number, maxSpeed, year, liftingCapacity);
        this.batteryPowerReserve = batteryPowerReserve;
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
                "engine='" + getEngine() +
                ", color='" + getColor() +
                ", number='" + getNumber() +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", liftingCapacity=" + getLiftingCapacity() +
                ", batteryPowerReserve=" + batteryPowerReserve +
                '}';
    }
}
