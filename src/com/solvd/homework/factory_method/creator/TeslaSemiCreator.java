package com.solvd.homework.factory_method.creator;

import com.solvd.homework.vehicle.Vehicle;
import com.solvd.homework.vehicle.final_car.TeslaSemi;

public class TeslaSemiCreator implements CarCreator {

    /**
     * create Tesla Semi instance
     * @param color -> parameter of the car
     * @param number -> parameter of the car
     * @param maxSpeed -> parameter of the car
     * @param year -> parameter of the car
     * @return Tesla Semi instance
     */
    @Override
    public Vehicle createCar(String color, String number, int maxSpeed, int year) {
        return new TeslaSemi(color, number, maxSpeed, year, 20, 800);
    }

}
