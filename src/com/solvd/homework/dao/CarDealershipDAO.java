package com.solvd.homework.dao;

import com.solvd.homework.place.CarDealership;
import com.solvd.homework.vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CarDealershipDAO extends VehiclePlaceDAO<CarDealership<Vehicle>> {

    public CarDealershipDAO(String filePath) {
        super(filePath);
    }

    @Override
    public void writeToFile(Vehicle vehicle) {
        StringBuilder sb = new StringBuilder();

        if (vehicle != null) {
            sb.append(fromVehicleToString(vehicle));
        }
        sb.append(System.lineSeparator());

        writeStringToFile(sb.toString());
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

        writeStringToFile(sb.toString());
    }

    @Override
    public CarDealership<Vehicle> readAllFromFile() {
        CarDealership<Vehicle> carDealership = new CarDealership<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFile()))){
            String line = "";
            while ((line = reader.readLine()) != null) {
                carDealership.add(fromStringToVehicle(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return carDealership;
    }

    @Override
    public void clearFile() {
        try {
            PrintWriter writer = new PrintWriter(getFile());
            writer.print("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
