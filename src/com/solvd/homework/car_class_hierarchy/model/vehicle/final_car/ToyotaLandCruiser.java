package com.solvd.homework.car_class_hierarchy.model.vehicle.final_car;

import com.solvd.homework.car_class_hierarchy.model.interfaces.Car;
import com.solvd.homework.car_class_hierarchy.model.interfaces.CarModel;
import com.solvd.homework.car_class_hierarchy.model.vehicle.Engine;
import com.solvd.homework.car_class_hierarchy.model.vehicle.SUV;

public final class ToyotaLandCruiser extends SUV implements CarModel, Car {
    private boolean isThereBackViewCamera;

    public ToyotaLandCruiser(int maxSpeed, int year) {
        super(Engine.V8, maxSpeed, year);
        this.isThereBackViewCamera = true;
        setThereTopTrunk(true);
    }

    public ToyotaLandCruiser(String color, String number, int maxSpeed, int year, int clearanceLength) {
        super(Engine.V8, color, number, maxSpeed, year, true, clearanceLength + 5);
        this.isThereBackViewCamera = true;
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
