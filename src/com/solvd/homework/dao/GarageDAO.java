package com.solvd.homework.dao;

import com.solvd.homework.place.Garage;
import com.solvd.homework.vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GarageDAO extends VehiclePlaceDAO<Garage<Vehicle>> {

    public GarageDAO(String filePath) {
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
    public void writeAllToFile(Garage<Vehicle> garage) {
        StringBuilder sb = new StringBuilder();

        for (Vehicle vehicle: garage.getCarsInGarage()) {
            if (vehicle != null) {
                sb.append(fromVehicleToString(vehicle));
            }
            sb.append(System.lineSeparator());
        }

        writeStringToFile(sb.toString());
    }

    @Override
    public Garage<Vehicle> readAllFromFile() {
        Garage<Vehicle> garage = new Garage<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFile()))){
            String line = "";
            while ((line = reader.readLine()) != null) {
                garage.add(fromStringToVehicle(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return garage;
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
