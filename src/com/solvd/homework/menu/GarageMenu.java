package com.solvd.homework.menu;

import java.util.Scanner;

public class GarageMenu {
    private Scanner in;
    private HomesMenu homesMenu;
    private String inputIndex;

    private boolean isCarInTheGarage = false;

    public GarageMenu(HomesMenu homesMenu) {
        this.homesMenu = homesMenu;
    }

    public boolean isCarInTheGarage() {
        return isCarInTheGarage;
    }

    public void setCarInTheGarage(boolean carInTheGarage) {
        isCarInTheGarage = carInTheGarage;
    }

    public void inputGarageOperation () {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input                       -> -1|");
                System.out.println("Go back input(inputted address won't save) -> -2|");
                System.out.println("------------------------------------------------|");
                System.out.println("Add car to garage input                    ->  1|");
                System.out.println("Show all cars in the garage input          ->  2|");
                System.out.println("Create home with address and garage        ->  3|");

                inputIndex = in.nextLine();
                if (inputIndex.equals("-1")) {
                    System.exit(0);
                    break;
                }
                else if (inputIndex.equals("-2")) {
                    homesMenu.openCreateHomeMenu();
                    break;
                }
                else if (!inputIndex.equals("") && inputIndex.matches("^([1-9][0-9]*)$")) {
                    switch (inputIndex) {
                        case "1":
                            openAddCarToGarageMenu();
                            break;
                        case "2":
                            homesMenu.showCarInTheGarage();
                            inputGarageOperation();
                            break;
                        case "3":
                            if (isCarInTheGarage) {
                                System.out.println("Home created!");
                                homesMenu.createHome();
                                homesMenu.inputHomesOperation();
                            }
                            else {
                                System.out.println("To create the home you have to add at least 1 car to garage!");
                                inputGarageOperation();
                            }
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

    private void openAddCarToGarageMenu() {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Input number of car to add to garage    |");
                System.out.println("----------------------------------------|");
                homesMenu.getMainMenu().showAllCars();

                inputIndex = in.nextLine();
                if (inputIndex.equals("-1")) {
                    System.exit(0);
                    break;
                }
                else if (inputIndex.equals("-2")) {
                    inputGarageOperation();
                    break;
                }
                else if (!inputIndex.equals("") && inputIndex.matches("^([1-9][0-9]*|[0])$")) {
                    int carIndex = Integer.parseInt(inputIndex);
                    if (carIndex >= 0 && carIndex < homesMenu.getMainMenu().getCarListInstance().size()) {
                        homesMenu.getGarage().add(homesMenu.getMainMenu().getCarListInstance().get(carIndex));
                        isCarInTheGarage = true;
                        System.out.println("Car " + homesMenu.getMainMenu().getCarListInstance().get(carIndex).getShortInfo()
                                + " added to garage");
                        inputGarageOperation();
                    }
                    else {
                        System.out.println("Such car does not exist!");
                        openAddCarToGarageMenu();
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

}
