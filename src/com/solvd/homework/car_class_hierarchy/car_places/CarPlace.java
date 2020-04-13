package com.solvd.homework.car_class_hierarchy.car_places;

import com.solvd.homework.car_class_hierarchy.vehicle.interfaces.Car;

public interface CarPlace {
    void add(Car car);
    Car leaveThePlace(Car car);
    void showInfo();
}
