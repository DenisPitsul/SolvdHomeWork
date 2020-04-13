package com.solvd.homework.car_class_hierarchy.car_places;

import com.solvd.homework.car_class_hierarchy.vehicle.interfaces.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDealership implements CarPlace{
    private List<Car> sellingCars;

    public CarDealership() {
        sellingCars = new ArrayList<>();
    }

    public List<Car> getSellingCars() {
        return sellingCars;
    }

    public void setSellingCars(List<Car> sellingCars) {
        this.sellingCars = sellingCars;
    }

    @Override
    public void add(Car car) {
        sellingCars.add(car);
    }

    @Override
    public Car leaveThePlace(Car selectedCar) {
        Car car = null;
        boolean isCarExist = false;
        for (Car eachCar : sellingCars) {
            if (eachCar == selectedCar) {
                car = selectedCar;
                isCarExist = true;
                break;
            }
        }
        if (!isCarExist) {
            return null;
        }
        sellingCars.remove(car);
        return car;
    }

    public Car leaveTheCarDealership(int carPlaceIndex) {
        if (sellingCars.get(carPlaceIndex) == null) {
            return null;
        }
        return sellingCars.remove(carPlaceIndex);
    }

    @Override
    public void showInfo() {
        System.out.println("Car dealership {");
        int i = 0;
        for (Car car : sellingCars) {
            System.out.println("\tCar №" + i + ": " + car.getShortInfo());
            i++;
        }
        System.out.println("}");
    }
}
