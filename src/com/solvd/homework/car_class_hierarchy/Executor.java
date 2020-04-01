package com.solvd.homework.car_class_hierarchy;

import com.solvd.homework.car_class_hierarchy.model.vehicle.AudiA6;
import com.solvd.homework.car_class_hierarchy.model.vehicle.MercedesVito;
import com.solvd.homework.car_class_hierarchy.model.vehicle.TeslaSemi;
import com.solvd.homework.car_class_hierarchy.model.vehicle.ToyotaLandCruiser;
import com.solvd.homework.car_class_hierarchy.model.interfaces.Car;
import com.solvd.homework.car_class_hierarchy.model.parking.Parking;

public class Executor {

    public static void main(String[] args) {

        System.out.println("--------------------------------------------------");

//        AudiA6 audiA6 = new AudiA6(260, 2015);
//        audiA6.setColor("black");
//        audiA6.setNumber("CE4567AA");
//        audiA6.setWheelRadius(19);
//        audiA6.setSalon("Alcantara");

        AudiA6 audiA6 = new AudiA6("black", "CE4567AA", 260, 2015, 19, "Alcantara");

        System.out.println(audiA6.accelerate(30));
        System.out.println(audiA6.accelerate(90));
        System.out.println(audiA6.accelerate(160));
        System.out.println(audiA6.decelerate(100));
        System.out.println(audiA6.decelerate(200));

        audiA6.printInfo();

        System.out.println("--------------------------------------------------");

//        MercedesVito mercedesVito = new MercedesVito(240, 2012);
//        mercedesVito.setColor("white");
//        mercedesVito.setNumber("CE2901AA");
//        mercedesVito.setPassengerSeatsCount(7);

        Car mercedesVito = new MercedesVito("white", "CE2901AA", 240, 2012, 7);

        mercedesVito.printInfo();

        System.out.println("--------------------------------------------------");

//        ToyotaLandCruiser toyotaLandCruiser = new ToyotaLandCruiser(240, 2014);
//        toyotaLandCruiser.setColor("yelow");
//        toyotaLandCruiser.setNumber("CE6511AA");
//        toyotaLandCruiser.setClearanceLength(50);

        Car toyotaLandCruiser = new ToyotaLandCruiser("yelow", "CE6511AA", 240, 2014, 50);

        toyotaLandCruiser.printInfo();

        System.out.println("--------------------------------------------------");

//        TeslaSemi teslaSemi = new TeslaSemi(200, 2017);
//        teslaSemi.setColor("grey");
//        teslaSemi.setNumber("CE4099AA");
//        teslaSemi.setLiftingCapacity(20);
//        teslaSemi.setBatteryPowerReserve(800);
//        teslaSemi.honk();

        Car teslaSemi = new TeslaSemi("grey", "CE4099AA", 200, 2017, 20, 800);

        teslaSemi.printInfo();

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");

        Car audiA6_2 = new AudiA6("red", "CE5510AA", 260, 2016, 20, "Leather");
        Car toyotaLandCruiser_2 = new ToyotaLandCruiser("blue", "CE8201AA", 240, 2012, 45);

        Parking parking = new Parking(4);
        parking.parkCar(audiA6_2);
        parking.parkCar(mercedesVito);
        parking.parkCar(toyotaLandCruiser_2);
        parking.parkCar(teslaSemi);

        parking.parkCar(audiA6);
        parking.leaveTheParking(toyotaLandCruiser_2);

        System.out.println("--------------------------------------------------");
        parking.showInfoAboutCarsOnTheParking();
        System.out.println("--------------------------------------------------");

        parking.leaveTheParking(2);
        parking.leaveTheParking(toyotaLandCruiser_2);
        parking.leaveTheParking(audiA6_2);

        System.out.println("--------------------------------------------------");
        parking.showInfoAboutCarsOnTheParking();
        System.out.println("--------------------------------------------------");

        parking.parkCar(toyotaLandCruiser);
        parking.parkCar(toyotaLandCruiser);
        parking.parkCar(audiA6);
        parking.parkCar(audiA6_2);

        System.out.println("--------------------------------------------------");
        parking.showInfoAboutCarsOnTheParking();
        System.out.println("--------------------------------------------------");

    }

}
