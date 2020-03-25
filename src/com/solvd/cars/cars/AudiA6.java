package com.solvd.cars.cars;

public class AudiA6 extends Sedan {
    private String salon;
    private boolean isThereBackViewCamera;

    public AudiA6(String color, String number, int maxSpeed, int year, int wheelRadius, String salon) {
        super("V6+Turbo", color, number, maxSpeed, year, wheelRadius);
        this.salon = salon;
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

    public void setThereBackViewCamera(boolean thereBackViewCamera) {
        isThereBackViewCamera = thereBackViewCamera;
    }

    @Override
    public String toString() {
        return "AudiA6{" +
                "engine='" + getEngine() +
                ", color='" + getColor() +
                ", number='" + getNumber() +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", wheelRadius=" + getWheelRadius() +
                ", salon='" + salon +
                ", isThereBackViewCamera=" + isThereBackViewCamera +
                '}';
    }
}
