package com.solvd.homework.car_class_hierarchy.factory_method.creator;

import com.solvd.homework.car_class_hierarchy.vehicle.interfaces.Car;

public interface CarCreator {
    Car createCar(String color, String number, int maxSpeed, int year);
}
