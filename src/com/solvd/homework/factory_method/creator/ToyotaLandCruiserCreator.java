package com.solvd.homework.factory_method.creator;

import com.solvd.homework.vehicle.Vehicle;
import com.solvd.homework.vehicle.final_car.ToyotaLandCruiser;

public class ToyotaLandCruiserCreator implements CarCreator {

    /**
     * create Toyota Land Cruiser instance
     * @param color -> parameter of the car
     * @param number -> parameter of the car
     * @param maxSpeed -> parameter of the car
     * @param year -> parameter of the car
     * @return Toyota Land Cruiser instance
     */
    @Override
    public Vehicle createCar(String color, String number, int maxSpeed, int year) {
        return new ToyotaLandCruiser(color, number, maxSpeed, year, 50);
    }

}
