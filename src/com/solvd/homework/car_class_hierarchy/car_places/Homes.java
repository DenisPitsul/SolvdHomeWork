package com.solvd.homework.car_class_hierarchy.car_places;

import java.util.HashMap;
import java.util.Map;

public class Homes {
    private Map<Address, Garage> homes;

    public Homes() {
        homes = new HashMap<>();
    }

    public Map<Address, Garage> getHomes() {
        return homes;
    }

    public void setHomes(Map<Address, Garage> homes) {
        this.homes = homes;
    }

    public void addHome(Address address, Garage garage) {
        homes.put(address, garage);
    }

    public Garage deleteHome(Address address) {
        if (homes.get(address) == null) {
            System.out.println("Car with this index does not exist!");
            return null;
        }
        System.out.println("Removed home from this address: " + address);
        return homes.remove(address);
    }

    public void deleteHome(int index) {
        if (homes.size() == 0) {
            System.out.println("There is not any homes");
        }

        if (index >= 0 && index < homes.size()) {
            int i = 0;
            boolean isHomeRemoved = false;
            for (Address address : homes.keySet()) {
                if (i == index) {
                    homes.remove(address);
                    isHomeRemoved = true;
                    System.out.println("Removed home from this address: " + address);
                    break;
                }
                i++;
            }
            if (!isHomeRemoved) {
                System.out.println("Car with this index does not exist!");
            }
        }
    }

    public void showInfo() {
        System.out.println("Homes {");
        int i = 0;
        for (Address address : homes.keySet()) {
            System.out.println("\t Home №"+ i);
            System.out.println("\t\tAddress: " + address);
            System.out.println(homes.get(address));
            i++;
        }
        System.out.println("}");
    }
}
