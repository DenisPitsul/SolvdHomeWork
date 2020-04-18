package com.solvd.homework.menu;

import com.solvd.homework.place.Address;
import com.solvd.homework.place.Garage;

import java.util.InputMismatchException;
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

    /**
     * if we have not opened AddressMenu instance yet then create and return
     * @return addressMenu instance
     */
    private AddressMenu getAddressMenuInstance() {
        if (addressMenu == null) {
            addressMenu = new AddressMenu(this);
        }
        return addressMenu;
    }

    /**
     * if we have not opened GarageMenu instance yet then create and return
     * @return garageMenu instance
     */
    private GarageMenu getGarageMenuInstance() {
        if (garageMenu == null) {
            garageMenu = new GarageMenu(this);
        }
        garageMenu.setCarInTheGarage(false);
        return garageMenu;
    }

    /**
     * Show all added car in current garage on the screen
     */
    public void showCarInTheGarage() {
        if (getGarage().getCarsInGarage() == null || getGarage().getCarsInGarage().size() == 0) {
            System.out.println("There is not any car in the garage!");
            inputHomesOperation();
            return;
        }
        garage.showInfo();
    }

    /**
     * Choose a home action.
     * 1 -> Create home
     * 2 -> delete home
     * 3 -> Show info about all homes
     */
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
                System.out.println("Show info about all homes          ->  3|");

                inputIndex = in.nextLine();

                switch (inputIndex) {
                    case "-1":
                        System.exit(0);
                        break;
                    case "-2":
                        mainMenu.openMainMenu();
                        break;
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
                    default:
                        System.out.println("You have to input number from menu.");
                        inputHomesOperation();
                        break;
                }
                break;
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct number.");
            } finally {
                inputHomesOperation();
            }
        }
    }

    /**
     * To create home to have to create address of home and add car to garage.
     * In this method we choose option to create the address of the home
     * Choose 1 to address of the home manually
     * Choose 2 to address of the home automatically
     * If we choose 2 address of the home will be created and will open garage menu
     */
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

                switch (inputIndex) {
                    case "-1":
                        System.exit(0);
                        break;
                    case "-2":
                        inputHomesOperation();
                        break;
                    case "1":
                        openAddressMenu();
                        break;
                    case "2":
                        address = new Address.Builder()
                                .setCity("Chernivtsy")
                                .setStreet("Nebesnoy sotny")
                                .setHouseNumber(houseNumber)
                                .build();
                        houseNumber++;
                        openGarageMenu();
                        break;
                    default:
                        System.out.println("You have to input correct number.");
                        openCreateHomeMenu();
                        break;
                }
                break;
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct number.");
            } finally {
                openCreateHomeMenu();
            }
        }
    }

    /**
     * Show all homes on the screen and choose number of home to leave delete
     */
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

                switch (inputIndex) {
                    case "-1":
                        System.exit(0);
                        break;
                    case "-2":
                        inputHomesOperation();
                        break;
                    default:
                        if (!inputIndex.equals("")) {
                            int carIndex = Integer.parseInt(inputIndex);
                            if (carIndex >= 0 && carIndex < mainMenu.getHomesInstance().getHomes().size()) {
                                mainMenu.getHomesInstance().deleteHome(carIndex);
                                inputHomesOperation();
                            }
                            else {
                                System.out.println("Such home does not exist!");
                                openDeleteHomeMenu();
                            }
                        }
                        else {
                            System.out.println("You have to input correct number.");
                            openDeleteHomeMenu();
                        }
                        break;
                }
                break;
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct number.");
            } finally {
                openDeleteHomeMenu();
            }
        }
    }

    /**
     * Go to address menu
     */
    public void openAddressMenu() {
        AddressMenu addressMenu = getAddressMenuInstance();
        addressMenu.inputAddressManually(0);
    }

    /**
     * Go to garage menu
     */
    public void openGarageMenu() {
        GarageMenu garageMenu = getGarageMenuInstance();
        garageMenu.inputGarageOperation();
    }

    /**
     * Add home with address and garage to map
     */
    public void createHome() {
        mainMenu.getHomesInstance().getHomes().put(address, garage);
    }
}
