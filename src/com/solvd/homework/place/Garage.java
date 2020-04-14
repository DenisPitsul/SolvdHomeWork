package com.solvd.homework.place;

import com.solvd.homework.vehicle.interfaces.Car;

import java.util.HashSet;
import java.util.Set;

public class Garage implements CarPlace {
    private Set<Car> carsInGarage;

    public Garage() {
        carsInGarage = new HashSet<>();
    }

    public Set<Car> getCarsInGarage() {
        return carsInGarage;
    }

    public void setCarsInGarage(Set<Car> carsInGarage) {
        this.carsInGarage = carsInGarage;
    }

    @Override
    public void add(Car car) {
        carsInGarage.add(car);
    }

    @Override
    public Car leaveThePlace(Car carInGarage) {
        Car car = null;
        boolean isCarExist = false;
        for (Car eachCar : carsInGarage) {
            if (eachCar == carInGarage) {
                car = carInGarage;
                isCarExist = true;
                break;
            }
        }
        if (!isCarExist) {
            return null;
        }
        carsInGarage.remove(car);
        return car;
    }

    @Override
    public void showInfo() {
        System.out.println("Garage {");
        int i = 0;
        for (Car car : carsInGarage) {
            System.out.println("\tCar №" + i + ": " + car.getShortInfo());
            i++;
        }
        System.out.println("}");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tGarage {\n");
        int i = 0;
        for (Car car : carsInGarage) {
            sb.append("\t\t\tCar №").append(i).append(": ").append(car.getShortInfo()).append("\n");
            i++;
        }
        sb.append("\t\t}");
        return sb.toString();
    }
}
