package com.solvd.homework.vehicle.final_car;

import com.solvd.homework.vehicle.interfaces.Car;
import com.solvd.homework.vehicle.interfaces.CarModel;
import com.solvd.homework.vehicle.helper.Engine;
import com.solvd.homework.vehicle.Sedan;

public final class AudiA6 extends Sedan implements CarModel, Car {
    private String salon;
    private boolean isThereBackViewCamera;

    public AudiA6(int maxSpeed, int year) {
        super(Engine.V6_TURBO, maxSpeed, year);
        this.isThereBackViewCamera = true;
    }

    public AudiA6(String color, String number, int maxSpeed, int year, int wheelRadius, String salon) {
        super(Engine.V6_TURBO, color, number, maxSpeed, year, wheelRadius);
        this.salon = salon;
        this.isThereBackViewCamera = true;
    }

    public AudiA6() {
        setEngine(Engine.V6_TURBO);
        setWheelRadius(19);
        this.salon = "Alcantara";
        this.isThereBackViewCamera = true;
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
                "model='" + getCarModel() + '\'' +
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
    public String getCarModel() {
        String className = this.getClass().getName();
        return className.substring(className.lastIndexOf(".") + 1);
    }

    @Override
    public int accelerate(int a) {
        if ((this.getVelocity() + a) <= this.getMaxSpeed())
            this.setVelocity(this.getVelocity() + a);
        else
            this.setVelocity(this.getMaxSpeed());

        return this.getVelocity();
    }

    @Override
    public int decelerate(int a) {
        if ((this.getVelocity() - a) >= 0)
            this.setVelocity(this.getVelocity() - a);
        else
            this.setVelocity(0);

        return this.getVelocity();
    }

    @Override
    public String getShortInfo() {
        return "Car{model='" + this.getCarModel() + "', number='" + this.getNumber() + "'}";
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }
}
