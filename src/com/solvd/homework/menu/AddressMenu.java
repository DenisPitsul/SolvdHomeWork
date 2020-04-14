package com.solvd.homework.menu;

import com.solvd.homework.place.Address;

import java.util.Scanner;

public class AddressMenu {
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
        int i = 0;
        while(i < 6) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Address                          |");
                System.out.println("----------------------------------------|");
                if(i == 0) {
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
                            if (!value.equals("") && value.matches("^([a-zA-Z]*)$")) {
                                address.setCity(value);
                                i++;
                            }
                            else {
                                System.out.println("You have to input city!");
                            }
                            break;
                    }
                }
                else if (i == 1) {
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
                            i++;
                            break;
                        default:
                            if (!value.equals("") && value.matches("^([a-zA-Z]*)$")) {
                                address.setDistrict(value);
                                i++;
                            }
                            else {
                                System.out.println("You have to input district!");
                            }
                            break;
                    }
                }
                else if (i == 2) {
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
                            i++;
                            break;
                        default:
                            if (!value.equals("") && value.matches("^([a-zA-Z]*)$")) {
                                address.setVillage(value);
                                i++;
                            }
                            else {
                                System.out.println("You have to input village!");
                            }
                            break;
                    }
                }
                else if (i == 3) {
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
                            if (!value.equals("") && value.matches("^([a-zA-Z]*)$")) {
                                address.setStreet(value);
                                i++;
                            }
                            else {
                                System.out.println("You have to input street!");
                            }
                            break;
                    }
                }
                else if (i == 4) {
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
                            if (!value.equals("") && value.matches("^([1-9][0-9]*)$")) {
                                address.setHouseNumber(Integer.parseInt(value));
                                i++;
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
                    i++;
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}
