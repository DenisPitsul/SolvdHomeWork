package com.solvd.cars.cars;

public class Car extends Vehicle {
    private String color;
    private String number;
    private int maxSpeed;
    private int year;

    private int velocity;

    public Car(String engine, String color, String number, int maxSpeed, int year) {
        super(engine);
        this.color = color;
        this.number = number;
        this.maxSpeed = maxSpeed;
        this.year = year;
    }

    public Car() {
    }

    public void honk() {
        System.out.println("Beep beep!!");
    }

    public void accelerate(double a) {
        if ((velocity+a) <= maxSpeed) {
            velocity += a;
        }
        else {
            velocity = maxSpeed;
        }
    }

    public void decelerate(double a) {
        if ((velocity-a) >= 0) {
            velocity -= a;
        }
        else {
            velocity = 0;
        }
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
    public String toString() {
        return "Car{" +
                "engine='" + getEngine() +
                ", color='" + color +
                ", number='" + number +
                ", maxSpeed=" + maxSpeed +
                ", year=" + year +
                '}';
    }
}
