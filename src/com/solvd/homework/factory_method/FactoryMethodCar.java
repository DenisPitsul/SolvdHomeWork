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
        Vehicle car;

        switch (carModel) {
            case AUDI_A6:
                car = createAudiA6();
                break;
            case MERCEDES_VITO:
                car = createMercedesVito();
                break;
            case TOYOTA_LAND_CRUISER:
                car = createToyotaLandCruiser();
                break;
            case TESLA_SEMI:
                car = createTeslaSemi();
                break;
            default:
                car = createDefaultCar();
                break;
        }

        return car;
    }

    private static Vehicle createAudiA6() {
        CarCreator creator = new AudiA6Creator();
        return creator.createCar("red", "CE5510AA", 260, 2016);
    }

    private static Vehicle createMercedesVito() {
        CarCreator creator = new MercedesVitoCreator();
        return creator.createCar("white", "CE2901AA", 240, 2012);
    }

    private static Vehicle createToyotaLandCruiser() {
        CarCreator creator = new ToyotaLandCruiserCreator();
        return creator.createCar("yellow", "CE6511AA", 240, 2014);
    }

    private static Vehicle createTeslaSemi() {
        CarCreator creator = new TeslaSemiCreator();
        return creator.createCar("grey", "CE4099AA", 200, 2017);
    }

    private static Vehicle createDefaultCar() {
        CarCreator creator = new DefaultCreator();
        return creator.createCar("blue", "CE4100AA", 250, 2014);
    }
}
