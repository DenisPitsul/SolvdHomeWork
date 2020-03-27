package com.solvd.cars.cars;

public class AudiA6 extends Sedan {
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
                "engine='" + getEngine() + '\'' +
                ", color='" + getColor() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", maxSpeed=" + getMaxSpeed() +
                ", year=" + getYear() +
                ", wheelRadius=" + getWheelRadius() +
                ", salon='" + salon + '\'' +
                ", isThereBackViewCamera=" + isThereBackViewCamera +
                '}';
    }
}
