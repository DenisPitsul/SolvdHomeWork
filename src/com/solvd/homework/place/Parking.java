package com.solvd.homework.place;

import com.solvd.homework.vehicle.interfaces.Car;

import java.util.LinkedList;
import java.util.List;

public class Parking implements CarPlace {
    private List<Car> parkingCars;

    public Parking() {
        parkingCars = new LinkedList<>();
    }

    public List<Car> getParkingCars() {
        return parkingCars;
    }

    public void setParkingCars(List<Car> parkingCars) {
        this.parkingCars = parkingCars;
    }

    @Override
    public void add(Car car) {
        parkingCars.add(car);
    }

    @Override
    public Car leaveThePlace(Car parkedCar) {
        Car car = null;
        boolean isCarExist = false;
        for (Car eachCar : parkingCars) {
            if (eachCar == parkingCars) {
                car = parkedCar;
                isCarExist = true;
                break;
            }
        }
        if (!isCarExist) {
            return null;
        }
        parkingCars.remove(car);
        return car;
    }

    public Car leaveTheParking(int carPlaceIndex) {
        if (parkingCars.get(carPlaceIndex) == null) {
            return null;
        }
        return parkingCars.remove(carPlaceIndex);
    }

    @Override
    public void showInfo() {
        System.out.println("Parking {");
        for (int i = 0; i < parkingCars.size(); i++) {
            System.out.println("\tPlace №" + i + ": " + parkingCars.get(i).getShortInfo());
        }
        System.out.println("}");
    }

}
