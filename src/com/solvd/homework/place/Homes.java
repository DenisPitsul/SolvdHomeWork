package com.solvd.homework.place;

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

    /**
     * create home by address and garage and add to map
     * @param address key of the homes map
     * @param garage value of the homes map
     */
    public void addHome(Address address, Garage garage) {
        homes.put(address, garage);
    }

    /**
     * Delete home from the map by address
     * @param address of the home which have to delete from the map
     * @return garage of deleted home or null if there weren't any homes in the map with this addres
     */
    public Garage deleteHome(Address address) {
        if (homes.get(address) == null) {
            System.out.println("Car with this index does not exist!");
            return null;
        }
        System.out.println("Removed home from this address: " + address);
        return homes.remove(address);
    }

    /**
     * Delete home from the map by index
     * @param index -> index of home which have to delete from the map
     */
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

    /**
     * Show all homes on the screen
     */
    public void showInfo() {
        System.out.println("Homes {");
        int i = 0;
        for (Address address : homes.keySet()) {
            System.out.println("\t Home #"+ i);
            System.out.println("\t\tAddress: " + address);
            System.out.println(homes.get(address));
            i++;
        }
        System.out.println("}");
    }
}
