package com.solvd.homework.factory_method;

import com.solvd.homework.factory_method.creator.*;
import com.solvd.homework.vehicle.Vehicle;
import com.solvd.homework.vehicle.helper.CarModel;

public class FactoryMethodCar {

    /**
     * create car instance by carModel
     * @param carModel -> model of the car we have to create an instance of
     * @return created car instance
     */
    public static Vehicle createCar(CarModel carModel) {
        Vehicle car = null;
        CarCreator creator;

        switch (carModel) {
            case AUDI_A6:
                creator = new AudiA6Creator();
                car = creator.createCar("red", "CE5510AA", 260, 2016);
                break;
            case MERCEDES_VITO:
                creator = new MercedesVitoCreator();
                car = creator.createCar("white", "CE2901AA", 240, 2012);
                break;
            case TOYOTA_LAND_CRUISER:
                creator = new ToyotaLandCruiserCreator();
                car = creator.createCar("yellow", "CE6511AA", 240, 2014);
                break;
            case TESLA_SEMI:
                creator = new TeslaSemiCreator();
                car = creator.createCar("grey", "CE4099AA", 200, 2017);
                break;
            default:
                creator = new DefaultCreator();
                car = creator.createCar("blue", "CE4100AA", 250, 2014);
                break;
        }

        return car;
    }

}
