package com.solvd.homework.car_class_hierarchy.model.parking;

import com.solvd.homework.car_class_hierarchy.model.interfaces.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parking {
    private Car[] parkingCars;

    public Parking(int parkingSpaceCount) {
        parkingCars = new Car[parkingSpaceCount];
    }

    public Car[] getParkingCars() {
        return parkingCars;
    }

    public void setParkingCars(Car[] parkingCars) {
        this.parkingCars = parkingCars;
    }

    private int getFirstEmptyParkingSpace() {
        int firstEmptyParkingSpace = -1;
        for (int i = 0; i < parkingCars.length; i++) {
            if (parkingCars[i] == null) {
                firstEmptyParkingSpace = i;
                break;
            }
        }
        return firstEmptyParkingSpace;
    }

    private boolean isThereCarOnTheParking(Car car) {
        boolean isCarOnTheParking = false;
        int parkingSpaceNumber = -1;
        for (int i = 0; i < parkingCars.length; i++) {
            if (parkingCars[i] == car) {
                isCarOnTheParking = true;
                break;
            }
        }
        return isCarOnTheParking;
    }

    public void parkCar(Car car) {
        if (getFirstEmptyParkingSpace() == -1) {
            System.out.println("There are no available parking spaces!");
            return;
        }
        if (isThereCarOnTheParking(car)) {
            System.out.println(car.getShortInfo() + " is already on the parking");
            return;
        }
        System.out.println(car.getShortInfo() + " parked on the " + getFirstEmptyParkingSpace() + " space");
        parkingCars[getFirstEmptyParkingSpace()] = car;
    }

    public void leaveTheParking(Car car) {
        int parkingSpaceNumber = -1;
        for (int i = 0; i < parkingCars.length; i++) {
            if (parkingCars[i] == car) {
                parkingSpaceNumber = i;
                break;
            }
        }
        if (parkingSpaceNumber == -1) {
            System.out.println("There is not " + car.getShortInfo() + " on the park");
            return;
        }
        System.out.println(parkingCars[parkingSpaceNumber].getShortInfo() + " left the parking");
        parkingCars[parkingSpaceNumber] = null;
        System.out.println("Place " + parkingSpaceNumber + " has already vacated");
    }

    // overload previous method
    public void leaveTheParking(int parkingSpaceNumber) {
        if (parkingSpaceNumber < 0 || parkingSpaceNumber >= parkingCars.length) {
            System.out.println(parkingSpaceNumber + " place does not exist. Choose places from 0 to " + parkingCars.length);
            return;
        }
        if (parkingCars[parkingSpaceNumber] == null) {
            System.out.println("There is not any car on the " + parkingSpaceNumber + " parking space");
            return;
        }
        System.out.println(parkingCars[parkingSpaceNumber]+" left the parking");
        parkingCars[parkingSpaceNumber] = null;
        System.out.println("Place " + parkingSpaceNumber + " has already vacated");
    }

    public void showInfoAboutCarsOnTheParking() {
        System.out.println("Parking {");
        for (int i = 0; i < parkingCars.length; i++) {
            if (parkingCars[i] == null)
                System.out.println("\tPlace " + i + " is empty");
            else
                System.out.println("\tPlace " + i + " is " + parkingCars[i].getShortInfo());
        }
        System.out.println("}");
    }
}
