package com.solvd.homework.car_class_hierarchy;

import com.solvd.homework.car_class_hierarchy.model.AudiA6;
import com.solvd.homework.car_class_hierarchy.model.MercedesVito;
import com.solvd.homework.car_class_hierarchy.model.TeslaSemi;
import com.solvd.homework.car_class_hierarchy.model.ToyotaLandCruiser;

public class Executor {

    public static void main(String[] args) {

        System.out.println("--------------------------------------------------");

        AudiA6 audiA6 = new AudiA6(260, 2015);
        audiA6.setColor("black");
        audiA6.setNumber("CE4567AA");
        audiA6.setWheelRadius(19);
        audiA6.setSalon("Alcantara");

        System.out.println(audiA6.accelerate(30));
        System.out.println(audiA6.accelerate(90));
        System.out.println(audiA6.accelerate(160));
        System.out.println(audiA6.decelerate(100));
        System.out.println(audiA6.decelerate(200));

        audiA6.printInfo();

        System.out.println("--------------------------------------------------");

        MercedesVito mercedesVito = new MercedesVito(240, 2012);
        mercedesVito.setColor("white");
        mercedesVito.setNumber("CE2901AA");
        mercedesVito.setPassengerSeatsCount(7);

        mercedesVito.printInfo();

        System.out.println("--------------------------------------------------");

        ToyotaLandCruiser toyotaLandCruiser = new ToyotaLandCruiser(240, 2014);
        toyotaLandCruiser.setColor("yelow");
        toyotaLandCruiser.setNumber("CE6511AA");
        toyotaLandCruiser.setClearanceLength(50);

        toyotaLandCruiser.printInfo();

        System.out.println("--------------------------------------------------");

        TeslaSemi teslaSemi = new TeslaSemi(200, 2017);
        teslaSemi.setColor("grey");
        teslaSemi.setNumber("CE4099AA");
        teslaSemi.setLiftingCapacity(20);
        teslaSemi.setBatteryPowerReserve(800);

        teslaSemi.honk();
        teslaSemi.printInfo();

        System.out.println("--------------------------------------------------");

    }



}
