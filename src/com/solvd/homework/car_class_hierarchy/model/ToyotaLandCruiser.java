package com.solvd.homework.car_class_hierarchy.model;

import com.solvd.homework.car_class_hierarchy.model.interfaces.CarModel;

public class ToyotaLandCruiser extends SUV implements CarModel {
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
                "model='" + getCarModel() + '\'' +
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
    public String getCarModel() {
        String className = this.getClass().getName();
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
