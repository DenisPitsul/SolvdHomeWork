package com.solvd.cars.cars;

public class ToyotaLandCruiser extends SUV {
    private boolean isThereBackViewCamera;

    public ToyotaLandCruiser(String color, String number, int maxSpeed, int year,
                             int clearanceLength) {
        super("V8 4.5", color, number, maxSpeed, year, true, clearanceLength+5);
        this.isThereBackViewCamera = true;
    }

    public ToyotaLandCruiser() {
    }

    public boolean isThereBackViewCamera() {
        return isThereBackViewCamera;
    }

    public void setThereBackViewCamera(boolean thereBackViewCamera) {
        isThereBackViewCamera = thereBackViewCamera;
    }

    @Override
    public String toString() {
        return "ToyotaLandCruiser{" +
                "engine='" + getEngine() +
                ", color='" + getColor() +
                ", number='" + getNumber() +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", isThereTopTrunk=" + isThereTopTrunk() +
                ", clearanceLength=" + getClearanceLength() +
                ", isThereBackViewCamera=" + isThereBackViewCamera +
                '}';
    }
}
