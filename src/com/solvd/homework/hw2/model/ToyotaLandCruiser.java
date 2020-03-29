package com.solvd.homework.hw2.model;

import com.solvd.homework.hw2.model.interfaces.ICarModel;

public class ToyotaLandCruiser extends SUV implements ICarModel {
    private boolean isThereBackViewCamera;

    public ToyotaLandCruiser(int maxSpeed, int year) {
        super("V8 4.5", maxSpeed, year);
        this.isThereBackViewCamera = true;
        setThereTopTrunk(true);
    }

    public ToyotaLandCruiser() {
    }

    public boolean isThereBackViewCamera() {
        return isThereBackViewCamera;
    }

    public void setThereBackViewCamera(boolean isThereBackViewCamera) {
        this.isThereBackViewCamera = isThereBackViewCamera;
    }

    @Override
    public void setClearanceLength(int clearanceLength) {
        super.setClearanceLength(clearanceLength + 5);
    }

    @Override
    public String toString() {
        return "ToyotaLandCruiser{" +
                "model='" + carModel() + '\'' +
                ", engine='" + getEngine() + '\'' +
                ", color='" + getColor() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", isThereTopTrunk=" + isThereTopTrunk() +
                ", clearanceLength=" + getClearanceLength() +
                ", isThereBackViewCamera=" + isThereBackViewCamera +
                '}';
    }

    @Override
    public String carModel() {
        String className = this.getClass().getName();
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
