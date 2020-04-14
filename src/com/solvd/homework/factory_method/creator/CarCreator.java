package com.solvd.homework.factory_method.creator;

import com.solvd.homework.vehicle.interfaces.Car;

public interface CarCreator {
    Car createCar(String color, String number, int maxSpeed, int year);
}
