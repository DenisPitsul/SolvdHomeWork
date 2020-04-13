package com.solvd.homework.car_class_hierarchy.vehicle;

import com.solvd.homework.car_class_hierarchy.vehicle.helper.Engine;

public class Car extends Vehicle {
    private String color;
    private String number;
    private int maxSpeed;
    private int year;

    private int velocity;

    public Car(Engine engine, String color, String number, int maxSpeed, int year) {
        super(engine);
        this.color = color;
        this.number = number;
        this.maxSpeed = maxSpeed;
        this.year = year;
    }

    public Car(Engine engine, int maxSpeed, int year) {
        super(engine);
        this.maxSpeed = maxSpeed;
        this.year = year;
    }

    public Car() {
    }

    public void showVelocity() {
        System.out.println(velocity);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        if (velocity <= maxSpeed) {
            this.velocity = velocity;
        }
    }

    /**
     *
     */
    @Override
    public final void honk() {
        System.out.println("Beep beep!");
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + getEngine() + '\'' +
                ", color='" + color + '\'' +
                ", number='" + number + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", year=" + year +
                '}';
    }

}
