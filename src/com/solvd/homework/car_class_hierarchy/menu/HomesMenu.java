package com.solvd.homework.car_class_hierarchy.menu;

import com.solvd.homework.car_class_hierarchy.car_places.Address;
import com.solvd.homework.car_class_hierarchy.car_places.Garage;

import java.util.Scanner;

public class HomesMenu {
    private static int houseNumber = 1;

    private Address address;
    private Garage garage;

    private AddressMenu addressMenu;
    private GarageMenu garageMenu;

    private Scanner in;
    private MainMenu mainMenu;
    private String inputIndex;

    public HomesMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }

    private AddressMenu getAddressMenuInstance() {
        if (addressMenu == null) {
            addressMenu = new AddressMenu(this);
        }
        return addressMenu;
    }

    private GarageMenu getGarageMenuInstance() {
        if (garageMenu == null) {
            garageMenu = new GarageMenu(this);
        }
        garageMenu.setCarInTheGarage(false);
        return garageMenu;
    }

    public void showCarInTheGarage() {
        if (getGarage().getCarsInGarage() == null || getGarage().getCarsInGarage().size() == 0) {
            System.out.println("There is not any car in the garage!");
            inputHomesOperation();
            return;
        }
        garage.showInfo();
    }

    public void inputHomesOperation() {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create home input                  ->  1|");
                System.out.println("Delete home input                  ->  2|");
                System.out.println("Show info all homes                ->  3|");

                inputIndex = in.nextLine();
                if (inputIndex.equals("-1")) {
                    System.exit(0);
                    break;
                }
                else if (inputIndex.equals("-2")) {
                    mainMenu.openMainMenu();
                    break;
                }
                else if (!inputIndex.equals("") && inputIndex.matches("^([1-9][0-9]*)$")) {
                    switch (inputIndex) {
                        case "1":
                            garage = new Garage();
                            openCreateHomeMenu();
                            break;
                        case "2":
                            openDeleteHomeMenu();
                            break;
                        case "3":
                            mainMenu.showAllHomes();
                            inputHomesOperation();
                            break;
                    }
                    break;
                }
                else {
                    System.out.println("You have to input correct number.");
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void openCreateHomeMenu() {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create address manually            ->  1|");
                System.out.println("Create address automatically       ->  2|");

                inputIndex = in.nextLine();
                if (inputIndex.equals("-1")) {
                    System.exit(0);
                    break;
                }
                else if (inputIndex.equals("-2")) {
                    inputHomesOperation();
                    break;
                }
                else if (inputIndex.equals("1")) {
                    openAddressMenu();
                    break;
                }
                else if (inputIndex.equals("2")) {
                    address = new Address.Builder()
                            .setCity("Chernivtsy")
                            .setStreet("Nebesnoy sotny")
                            .setHouseNumber(houseNumber)
                            .build();
                    openGarageMenu();
                }
                else {
                    System.out.println("You have to input correct number.");
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void openDeleteHomeMenu() {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input                -> -1|");
                System.out.println("Go back input                       -> -2|");
                System.out.println("-----------------------------------------|");
                System.out.println("Input number of home to delete           |");
                System.out.println("-----------------------------------------|");
                mainMenu.showAllHomes();

                inputIndex = in.nextLine();
                if (inputIndex.equals("-1")) {
                    System.exit(0);
                    break;
                }
                else if (inputIndex.equals("-2")) {
                    inputHomesOperation();
                    break;
                }
                else if (!inputIndex.equals("") && inputIndex.matches("^([1-9][0-9]*|[0])$")) {
                    int carIndex = Integer.parseInt(inputIndex);
                    if (carIndex >= 0 && carIndex < mainMenu.getHomesInstance().getHomes().size()) {
                        mainMenu.getHomesInstance().deleteHome(carIndex);
                        inputHomesOperation();
                    }
                    else {
                        System.out.println("Such home does not exist!");
                        openDeleteHomeMenu();
                    }
                    break;
                }
                else {
                    System.out.println("You have to input correct number.");
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void openAddressMenu() {
        AddressMenu addressMenu = getAddressMenuInstance();
        addressMenu.inputAddressManually();
    }

    public void openGarageMenu() {
        GarageMenu garageMenu = getGarageMenuInstance();
        garageMenu.inputGarageOperation();
    }

    public void createHome() {
        mainMenu.getHomesInstance().getHomes().put(address, garage);
    }
}
