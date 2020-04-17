package com.solvd.homework.menu;

import com.solvd.homework.place.Address;

import java.util.Scanner;

public class AddressMenu {
    private static final String ONLY_LETTERS_REGEX = "^([a-zA-Z]*)$";
    private static final String ONLY_NUMBERS_REGEX = "^([1-9][0-9]*)$";

    private Scanner in;
    private HomesMenu homesMenu;

    public AddressMenu(HomesMenu homesMenu) {
        this.homesMenu = homesMenu;
    }

    /**
     *  Create Address manually
     *  Input city, street and house number. It is required fields
     *  And in addition we can specify district and village if it is not city
     *  else we can specify 0 to miss entering these fields
     */
    public void inputAddressManually() {
        Address.Builder address = new Address.Builder();

        String value = "";
        /*
         *  number of iteration in method
         *  0 -> input city
         *  1 -> input district
         *  2 -> input village
         *  3 -> input street
         *  4 -> input house number
         *  5 -> create address
         */
        int propertyNumber = 0;
        while(propertyNumber < 6) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Address                          |");
                System.out.println("----------------------------------------|");
                if(propertyNumber == 0) {
                    System.out.print("Input city: ");
                    value = in.nextLine();
                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            homesMenu.openCreateHomeMenu();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_LETTERS_REGEX)) {
                                address.setCity(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input city!");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 1) {
                    System.out.print("Input district or 0 if it is city: ");
                    value = in.nextLine();
                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            homesMenu.openCreateHomeMenu();
                            break;
                        case "0":
                            propertyNumber++;
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_LETTERS_REGEX)) {
                                address.setDistrict(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input district!");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 2) {
                    System.out.print("Input village or 0 if it is city: ");
                    value = in.nextLine();
                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            homesMenu.openCreateHomeMenu();
                            break;
                        case "0":
                            propertyNumber++;
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_LETTERS_REGEX)) {
                                address.setVillage(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input village!");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 3) {
                    System.out.print("Input street: ");
                    value = in.nextLine();
                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            homesMenu.openCreateHomeMenu();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_LETTERS_REGEX)) {
                                address.setStreet(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input street!");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 4) {
                    System.out.print("Input house number: ");
                    value = in.nextLine();
                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            homesMenu.openCreateHomeMenu();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_NUMBERS_REGEX)) {
                                address.setHouseNumber(Integer.parseInt(value));
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input house number!");
                            }
                            break;
                    }
                }
                else {
                    System.out.println("Address created!");
                    homesMenu.setAddress(address.build());
                    homesMenu.openGarageMenu();
                    propertyNumber++;
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}
