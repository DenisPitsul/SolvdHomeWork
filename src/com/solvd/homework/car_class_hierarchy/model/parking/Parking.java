package com.solvd.homework.car_class_hierarchy.model.parking;

import com.solvd.homework.car_class_hierarchy.model.interfaces.Car;

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

    /**
     * get first vacant parking space
     *
     * @return -1 if there isn"t any vacant parking space or number of first empty parking space
     */
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

    /**
     *  check that car is in the parking lot
     *
     * @param car - this car will be checked
     * @return false if there is car on the parking or true if there isn't
     */
    private boolean isThereCarOnTheParking(Car car) {
        boolean isCarOnTheParking = false;
        for (int i = 0; i < parkingCars.length; i++) {
            if (parkingCars[i] == car) {
                isCarOnTheParking = true;
                break;
            }
        }
        return isCarOnTheParking;
    }

    /**
     * park the car on the parking if there is vacant parking space or this car is not on the parking
     * else print the message
     *
     * @param car - car which to park on the parking
     */
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

    /**
     * overload method leaveTheParking(int parkingSpaceNumber)
     *
     * @param car - car which we pick up from the parking
     */
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

    /**
     * overload method leaveTheParking(Car car)
     *
     * @param parkingSpaceNumber - parking space number which we make vacant
     */
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

    /**
     * show short info about cars which is present on the parking at the moment
     */
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
