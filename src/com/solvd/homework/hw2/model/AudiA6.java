package com.solvd.homework.hw2.model;

import com.solvd.homework.hw2.model.interfaces.ICarModel;

public class AudiA6 extends Sedan implements ICarModel {
    private String salon;
    private boolean isThereBackViewCamera;

    public AudiA6(int maxSpeed, int year) {
        super("V6+Turbo", maxSpeed, year);
        this.isThereBackViewCamera = true;
    }

    public AudiA6() {
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public boolean isThereBackViewCamera() {
        return isThereBackViewCamera;
    }

    public void setThereBackViewCamera(boolean isThereBackViewCamera) {
        this.isThereBackViewCamera = isThereBackViewCamera;
    }

    @Override
    public String toString() {
        return "AudiA6{" +
                "model='" + carModel() + '\'' +
                ", engine='" + getEngine() + '\'' +
                ", color='" + getColor() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", wheelRadius=" + getWheelRadius() +
                ", salon='" + salon + '\'' +
                ", isThereBackViewCamera=" + isThereBackViewCamera +
                '}';
    }

    @Override
    public String carModel() {
        String className = this.getClass().getName();
        return className.substring(className.lastIndexOf(".") + 1);
    }
}
