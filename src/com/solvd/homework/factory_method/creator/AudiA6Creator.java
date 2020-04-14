package com.solvd.homework.factory_method.creator;

import com.solvd.homework.vehicle.Vehicle;
import com.solvd.homework.vehicle.final_car.AudiA6;

public class AudiA6Creator implements CarCreator {

    /**
     * create Audi A6 instance
     * @param color -> parameter of the car
     * @param number -> parameter of the car
     * @param maxSpeed -> parameter of the car
     * @param year -> parameter of the car
     * @return Audi A6 instance
     */
    @Override
    public Vehicle createCar(String color, String number, int maxSpeed, int year) {
        return new AudiA6(color, number, maxSpeed, year, 19, "Alcantara");
    }

}
