package com.solvd.homework.menu;

import com.solvd.homework.place.Address;

import java.util.Scanner;

public class AddressMenu {
    private Scanner in;
    private HomesMenu homesMenu;

    public AddressMenu(HomesMenu homesMenu) {
        this.homesMenu = homesMenu;
    }

    public void inputAddressManually() {
        Address.Builder address = new Address.Builder();

        String value = "";
        int i = 0;
        while(true && i < 6) {
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
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-1")) {
                        homesMenu.openCreateHomeMenu();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^[a-zA-Z]*$")) {
                        address.setCity(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input city!");
                    }
                }
                else if (i == 1) {
                    System.out.print("Input district or 0 if it is city: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        homesMenu.openCreateHomeMenu();
                        break;
                    }
                    else if (value.equals("0")) {
                        i++;
                    }
                    else if (!value.equals("") && value.matches("^[a-zA-Z]*$")) {
                        address.setDistrict(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input car district!");
                    }
                }
                else if (i == 2) {
                    System.out.print("Input village or 0 if it is city: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        homesMenu.openCreateHomeMenu();
                        break;
                    }
                    else if (value.equals("0")) {
                        i++;
                    }
                    else if (!value.equals("") && value.matches("^([a-zA-Z]*)$")) {
                        address.setVillage(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input village!");
                    }
                }
                else if (i == 3) {
                    System.out.print("Input street: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        homesMenu.openCreateHomeMenu();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^([a-zA-Z]*)$")) {
                        address.setStreet(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input street!");
                    }
                }
                else if (i == 4) {
                    System.out.print("Input house number: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        homesMenu.openCreateHomeMenu();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^([1-9][0-9]*)$")) {
                        address.setHouseNumber(Integer.parseInt(value));
                        i++;
                    }
                    else {
                        System.out.println("You have to input house number!");
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
