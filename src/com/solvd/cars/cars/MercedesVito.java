package com.solvd.cars.cars;

public class MercedesVito extends MiniBus {
    private int passengerSeatsCount;

    public MercedesVito(String color, String number, int maxSpeed, int year, int passengerSeatsCount) {
        super("Desel 2.2", color, number, maxSpeed, year,true, true);
        this.passengerSeatsCount = passengerSeatsCount;
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
                "engine='" + getEngine() +
                ", color='" + getColor() +
                ", number='" + getNumber() +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", isPassenger=" + isPassenger() +
                ", isThereBackWindows=" + isThereBackWindows() +
                ", passengerSeatsCount=" + passengerSeatsCount +
                '}';
    }
}
