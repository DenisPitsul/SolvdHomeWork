package com.solvd.homework.hw2.model;

import com.solvd.homework.hw2.model.interfaces.ICar;
import com.solvd.homework.hw2.model.interfaces.Info;

public class Car extends Vehicle implements ICar, Info {
    private String color;
    private String number;
    private int maxSpeed;
    private int year;

    private int velocity;

    public Car(String engine, int maxSpeed, int year) {
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

    @Override
    public void honk() {
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

    @Override
    public int accelerate(double a) {
        if ((velocity+a) <= maxSpeed)
            velocity += a;
        else
            velocity = maxSpeed;

        return velocity;
    }

    @Override
    public int decelerate(double a) {
        if ((velocity-a) >= 0)
            velocity -= a;
        else
            velocity = 0;

        return velocity;
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }
}
