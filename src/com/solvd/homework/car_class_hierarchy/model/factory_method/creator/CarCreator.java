package com.solvd.homework.car_class_hierarchy.model.factory_method.creator;

import com.solvd.homework.car_class_hierarchy.model.interfaces.Car;

public interface CarCreator {
    Car createCar(String color, String number, int maxSpeed, int year);
}
