package com.solvd.homework.car_class_hierarchy.model.factory_method.creator;

import com.solvd.homework.car_class_hierarchy.model.interfaces.Car;
import com.solvd.homework.car_class_hierarchy.model.vehicle.final_car.TeslaSemi;

public class TeslaSemiCreator implements CarCreator {

    @Override
    public Car createCar(String color, String number, int maxSpeed, int year) {
        return new TeslaSemi(color, number, maxSpeed, year, 20, 800);
    }

}
