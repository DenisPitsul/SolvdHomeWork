package com.solvd.cars;

import com.solvd.cars.cars.AudiA6;
import com.solvd.cars.cars.MercedesVito;
import com.solvd.cars.cars.TeslaSemi;
import com.solvd.cars.cars.ToyotaLandCruiser;

public class Executor {

    public static void main(String[] args) {

        AudiA6 audiA6 = new AudiA6("black", "CE4567AA", 260,
                2015, 19, "Alcantara");

        System.out.println("---------------------------");

        audiA6.accelerate(30);
        audiA6.showVelocity();
        audiA6.accelerate(90);
        audiA6.showVelocity();
        audiA6.accelerate(160);
        audiA6.showVelocity();
        audiA6.decelerate(100);
        audiA6.showVelocity();
        audiA6.decelerate(200);
        audiA6.showVelocity();
        System.out.println(audiA6);

        System.out.println("---------------------------");

        MercedesVito mercedesVito = new MercedesVito("white", "CE2901AA", 240,
                2012, 7);
        System.out.println(mercedesVito);

        System.out.println("---------------------------");

        ToyotaLandCruiser toyotaLandCruiser = new ToyotaLandCruiser("yelow", "CE6511AA", 240,
                2014, 50);
        System.out.println(toyotaLandCruiser);

        System.out.println("---------------------------");

        TeslaSemi teslaSemi = new TeslaSemi("grey", "CE4099AA", 200,
                2017, 20, 800);
        teslaSemi.honk();
        System.out.println(teslaSemi);

        System.out.println("---------------------------");

    }
}
