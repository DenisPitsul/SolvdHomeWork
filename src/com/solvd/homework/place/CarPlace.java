package com.solvd.homework.place;

import com.solvd.homework.vehicle.interfaces.Car;

public interface CarPlace {
    void add(Car car);
    Car leaveThePlace(Car car);
    void showInfo();
}
