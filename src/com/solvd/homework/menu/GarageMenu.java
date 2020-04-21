package com.solvd.homework.menu;

import com.solvd.homework.exception.TruckInGarageException;
import com.solvd.homework.vehicle.Truck;
import com.solvd.homework.vehicle.Vehicle;

import java.util.InputMismatchException;
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

    /**
     * Choose a parking action.
     * 1 -> Add car to garage
     * 2 -> Show all cars in the garage
     * 3 -> create home if there is at least 1 car in garage
     */
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

                switch (inputIndex) {
                    case "-1":
                        System.exit(0);
                        break;
                    case "-2":
                        homesMenu.openCreateHomeMenu();
                        break;
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
                    default:
                        System.out.println("You have to input number from menu.");
                        inputGarageOperation();
                        break;
                }
                break;
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct number");
            } finally {
                inputGarageOperation();
            }
        }
    }

    /**
     * Input 1 to create big garage or 2 to create small garage.
     * After that show all cars on the screen and choose number of car to add to the garage
     */
    private void openAddCarToGarageMenu() {
        inputIndex = "";
        /*
         *  number of iteration in method
         *  0 -> input isBig garage
         *  1 -> add cars to garage
         */
        int propertyNumber = 0;
        while(true) {
            try {
                in = new Scanner(System.in);

                if (homesMenu.getGarage().isBigGarageValueSetted()) {
                    propertyNumber = 1;
                }

                if(propertyNumber == 0) {
                    System.out.println("Finish program input                       -> -1|");
                    System.out.println("Go back input                              -> -2|");
                    System.out.println("------------------------------------------------|");
                    System.out.println("Create big garage input                        ->  1|");
                    System.out.println("Create small garage input                      ->  2|");

                    inputIndex = in.nextLine();

                    switch (inputIndex) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputGarageOperation();
                            break;
                        case "1":
                            homesMenu.getGarage().setBig(true);
                            propertyNumber++;
                            break;
                        case "2":
                            homesMenu.getGarage().setBig(false);
                            propertyNumber++;
                            break;
                        default:
                            System.out.println("You have to input number from menu.");
                            openAddCarToGarageMenu();
                            break;
                    }
                    break;
                }
                else {
                    System.out.println("Finish program input               -> -1|");
                    System.out.println("Go back input                      -> -2|");
                    System.out.println("----------------------------------------|");
                    System.out.println("Input number of car to add to garage    |");
                    System.out.println("----------------------------------------|");
                    homesMenu.getMainMenu().showAllCars();

                    inputIndex = in.nextLine();

                    switch (inputIndex) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputGarageOperation();
                            break;
                        default:
                            if (!inputIndex.equals("")) {
                                int carIndex = Integer.parseInt(inputIndex);
                                if (carIndex >= 0 && carIndex < homesMenu.getMainMenu().getCarListInstance().size()) {
                                    Vehicle vehicle = homesMenu.getMainMenu().getCarListInstance().get(carIndex);
                                    if (vehicle instanceof Truck && !homesMenu.getGarage().isBig()) {
                                        throw new TruckInGarageException();
                                    }
                                    else {
                                        homesMenu.getGarage().add(vehicle);
                                        isCarInTheGarage = true;
                                        System.out.println("Car " + vehicle.getShortInfo() + " added to garage");
                                        inputGarageOperation();
                                    }
                                }
                                else {
                                    System.out.println("Such car does not exist!");
                                    openAddCarToGarageMenu();
                                }
                            }
                            else {
                                System.out.println("You have to input correct number.");
                                openAddCarToGarageMenu();
                            }
                            break;
                    }
                }
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct number.");
            } catch (TruckInGarageException e) {
                System.out.println(e.getMessage());
            } finally {
                openAddCarToGarageMenu();
            }
        }
    }

}
