package com.solvd.homework.place_io;

import com.solvd.homework.place.Garage;
import com.solvd.homework.place.Parking;
import com.solvd.homework.utils.FileIO;
import com.solvd.homework.vehicle.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class GarageIO extends VehiclePlaceIO<Garage<Vehicle>> {

    public GarageIO(String filePath) {
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
    public void writeAllToFile(Garage<Vehicle> garage) {
        StringBuilder sb = new StringBuilder();

        for (Vehicle vehicle: garage.getCarsInGarage()) {
            if (vehicle != null) {
                sb.append(fromVehicleToString(vehicle));
            }
            sb.append(System.lineSeparator());
        }

        FileIO.writeToFile(getFilePath(), sb.toString());
    }

    @Override
    public Garage<Vehicle> readAllFromFile() {
        Garage<Vehicle> garage = new Garage<>();
        String stringFromFile = FileIO.readFromFile(getFilePath());
        String[] lines = stringFromFile.split(System.getProperty("line.separator"));
        for (String line : lines) {
            garage.add(fromStringToVehicle(line));
        }
        return garage;
    }

    @Override
    public void clearFile() {
        FileIO.clearFile(getFilePath());
    }
}
