package com.solvd.homework.factory_method.creator;

import com.solvd.homework.vehicle.interfaces.Car;
import com.solvd.homework.vehicle.final_car.AudiA6;

public class AudiA6Creator implements CarCreator {

    @Override
    public Car createCar(String color, String number, int maxSpeed, int year) {
        return new AudiA6(color, number, maxSpeed, year, 19, "Alcantara");
    }

}
