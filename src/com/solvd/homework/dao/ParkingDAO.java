package com.solvd.homework.dao;

import com.solvd.homework.place.Parking;
import com.solvd.homework.vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ParkingDAO extends VehiclePlaceDAO<Parking<Vehicle>> {

    public ParkingDAO(String filePath) {
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
    public void writeAllToFile(Parking<Vehicle> parking) {
        StringBuilder sb = new StringBuilder();

        for (Vehicle vehicle: parking.getParkingCars()) {
            if (vehicle != null) {
                sb.append(fromVehicleToString(vehicle));
            }
            sb.append(System.lineSeparator());
        }

        writeStringToFile(sb.toString());
    }

    @Override
    public Parking<Vehicle> readAllFromFile() {
        Parking<Vehicle> parking = new Parking<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFile()))){
            String line = "";
            while ((line = reader.readLine()) != null) {
                parking.add(fromStringToVehicle(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parking;
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
