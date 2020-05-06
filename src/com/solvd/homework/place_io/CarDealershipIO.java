package com.solvd.homework.place_io;

import com.solvd.homework.place.CarDealership;
import com.solvd.homework.place.Parking;
import com.solvd.homework.utils.FileIO;
import com.solvd.homework.vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CarDealershipIO extends VehiclePlaceIO<CarDealership<Vehicle>> {
    public static final String CAR_DEALERSHIP_FILE_PATH = "files/car_dealership.txt";

    public CarDealershipIO(String filePath) {
        super(filePath);
    }

    @Override
    public void writeToFile(Vehicle vehicle) {
        StringBuilder sb = new StringBuilder();

        if (vehicle != null) {
            sb.append(fromVehicleToString(vehicle));
        }
        sb.append(System.lineSeparator());

        FileIO.writeToFile(getFilePath(), sb.toString());
    }

    @Override
    public void writeAllToFile(CarDealership<Vehicle> carDealership) {
        StringBuilder sb = new StringBuilder();

        for (Vehicle vehicle: carDealership.getSellingCars()) {
            if (vehicle != null) {
                sb.append(fromVehicleToString(vehicle));
            }
            sb.append(System.lineSeparator());
        }

        FileIO.writeToFile(getFilePath(), sb.toString());
    }

    @Override
    public CarDealership<Vehicle> readAllFromFile() {
        CarDealership<Vehicle> carDealership = new CarDealership<>();
        String stringFromFile = FileIO.readFromFile(getFilePath());
        String[] lines = stringFromFile.split(System.getProperty("line.separator"));
        for (String line : lines) {
            carDealership.add(fromStringToVehicle(line));
        }
        return carDealership;
    }

    @Override
    public void clearFile() {
        FileIO.clearFile(getFilePath());
    }
}
