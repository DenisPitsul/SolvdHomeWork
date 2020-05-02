package com.solvd.homework.dao;

import com.solvd.homework.place.Address;
import com.solvd.homework.place.Garage;
import com.solvd.homework.place.Homes;
import com.solvd.homework.vehicle.Vehicle;

import java.io.*;
import java.util.Map;

public class HomesDAO {
    private File file;
    private AddressDAO addressDAO;
    private GarageDAO garageDAO;

    public HomesDAO(String filePath) {
        this.file = new File(filePath);
        this.addressDAO = new AddressDAO();
        this.garageDAO = new GarageDAO(filePath);
    }

    public File getFile() {
        return file;
    }

    public void writeStringToFile(String str) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(Map.Entry<Address, Garage<Vehicle>> home) {
        StringBuilder sb = new StringBuilder();

        if (home != null) {
            sb.append(fromHomeToString(home));
        }
        sb.append("-").append(System.lineSeparator());

        writeStringToFile(sb.toString());
    }

    public void writeAllToFile(Homes homes) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Address, Garage<Vehicle>> home: homes.getHomes().entrySet()) {
            if (home != null) {
                sb.append(fromHomeToString(home));
            }
            sb.append("-").append(System.lineSeparator());
        }

        writeStringToFile(sb.toString());
    }

    public String fromHomeToString(Map.Entry<Address, Garage<Vehicle>> home) {
        StringBuilder sb = new StringBuilder();

        sb.append("Address").append(System.lineSeparator());
        sb.append(addressDAO.fromAddressToString(home.getKey())).append(System.lineSeparator());
        String bigField = home.getValue().isBig() ? "(big)" : "(small)";
        sb.append("Garage").append(bigField).append(System.lineSeparator());
        for (Vehicle vehicle: home.getValue().getCarsInGarage()) {
            sb.append(garageDAO.fromVehicleToString(vehicle)).append(System.lineSeparator());
        }

        return sb.toString();
    }

    public Homes readAllFromFile() {
        Homes homes = new Homes();
        Address address = null;
        Garage<Vehicle> garage = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(getFile()))){
            String line = "";
            /*
             * set 1 to statusFlag if line = Address, after that initialize address
             * set 2 to statusFlag if line = Garage, after that create add cars from file to the garage
             * set 0 to reset statusFlag
             */
            int statusFlag = -1;
            while ((line = reader.readLine()) != null) {
                switch (line) {
                    case "-":
                        homes.addHome(address, garage);
                        statusFlag = 0;
                        break;
                    case "Address":
                        statusFlag = 1;
                        address = null;
                        continue;
                    default:
                        if (line.startsWith("Garage")) {
                            statusFlag = 2;
                            garage = new Garage<>();
                            garage.setBig(line.endsWith("(big)"));
                            continue;
                        }
                }
                if (statusFlag == 1) {
                    address = addressDAO.fromStringToAddress(line);
                    statusFlag = 0;
                }
                else if (statusFlag == 2) {
                    garage.add(garageDAO.fromStringToVehicle(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return homes;
    }

    public void clearFile() {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}