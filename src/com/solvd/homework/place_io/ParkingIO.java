package com.solvd.homework.place_io;

import com.solvd.homework.place.Parking;
import com.solvd.homework.utils.FileIO;
import com.solvd.homework.vehicle.Vehicle;

public class ParkingIO extends VehiclePlaceIO<Parking<Vehicle>> {
    public static final String PARKING_FILE_PATH = "files/parking.txt";

    public ParkingIO(String filePath) {
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
    public void writeAllToFile(Parking<Vehicle> parking) {
        StringBuilder sb = new StringBuilder();

        for (Vehicle vehicle: parking.getParkingCars()) {
            if (vehicle != null) {
                sb.append(fromVehicleToString(vehicle));
            }
            sb.append(System.lineSeparator());
        }

        FileIO.writeToFile(getFilePath(), sb.toString());
    }

    @Override
    public Parking<Vehicle> readAllFromFile() {
        Parking<Vehicle> parking = new Parking<>();
        String stringFromFile = FileIO.readFromFile(getFilePath());
        String[] lines = stringFromFile.split(System.getProperty("line.separator"));
        for (String line : lines) {
            parking.add(fromStringToVehicle(line));
        }
        return parking;
    }

    @Override
    public void clearFile() {
        FileIO.clearFile(getFilePath());
    }
}
