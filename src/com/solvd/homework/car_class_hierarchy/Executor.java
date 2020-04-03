package com.solvd.homework.car_class_hierarchy;

import com.solvd.homework.car_class_hierarchy.model.factory_method.FactoryMethodCar;
import com.solvd.homework.car_class_hierarchy.model.vehicle.*;
import com.solvd.homework.car_class_hierarchy.model.interfaces.Car;

public class Executor {

    public static void main(String[] args) {

        Car audiA6 = FactoryMethodCar.createCar(CarModel.AUDI_A6);
        Car mercedesVito = FactoryMethodCar.createCar(CarModel.MERCEDES_VITO);
        Car toyotaLandCruiser = FactoryMethodCar.createCar(CarModel.TOYOTA_LAND_CRUISER);
        Car teslaSemi = FactoryMethodCar.createCar(CarModel.TESLA_SEMI);

        System.out.println(audiA6);
        System.out.println(mercedesVito);
        System.out.println(toyotaLandCruiser);
        System.out.println(teslaSemi);

    }

}
