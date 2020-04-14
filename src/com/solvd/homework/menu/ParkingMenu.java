package com.solvd.homework.menu;

import java.util.Scanner;

public class ParkingMenu {
    private Scanner in;
    private MainMenu mainMenu;
    private String inputIndex;

    public ParkingMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    /**
     * Choose a parking action.
     * 1 -> Add car to parking
     * 2 -> Leave car from the parking
     * 3 -> Show all cars on the parking
     */
    public void inputParkingOperation() {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Park Car                           ->  1|");
                System.out.println("Leave the Parking input            ->  2|");
                System.out.println("Show all cars on the parking input ->  3|");

                inputIndex = in.nextLine();

                switch (inputIndex) {
                    case "-1":
                        System.exit(0);
                        break;
                    case "-2":
                        mainMenu.openMainMenu();
                        break;
                    case "1":
                        openParkCarMenu();
                        break;
                    case "2":
                        openLeaveTheParkingMenu();
                        break;
                    case "3":
                        mainMenu.showCarsOnTheParking();
                        inputParkingOperation();
                        break;
                    default:
                        System.out.println("You have to input number from menu.");
                        inputParkingOperation();
                        break;
                }
                break;
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Show all cars on the screen and choose number of car to add to the parking
     */
    private void openParkCarMenu() {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Input number of car to park             |");
                System.out.println("----------------------------------------|");
                mainMenu.showAllCars();

                inputIndex = in.nextLine();

                switch (inputIndex) {
                    case "-1":
                        System.exit(0);
                        break;
                    case "-2":
                        inputParkingOperation();
                        break;
                    default:
                        if (!inputIndex.equals("") && inputIndex.matches("^([1-9][0-9]*|[0])$")) {
                            int carIndex = Integer.parseInt(inputIndex);
                            if (carIndex >= 0 && carIndex < mainMenu.getCarListInstance().size()) {
                                mainMenu.getParkingInstance().add(mainMenu.getCarListInstance().get(carIndex));
                                System.out.println("Car " + mainMenu.getCarListInstance().get(carIndex).getShortInfo() + " has parked");
                                inputParkingOperation();
                            }
                            else {
                                System.out.println("Such car does not exist!");
                                openParkCarMenu();
                            }
                        }
                        else {
                            System.out.println("You have to input correct number.");
                            openParkCarMenu();
                        }
                        break;
                }
                break;
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Show all cars on the screen on the parking and choose number of car to leave the parking
     */
    private void openLeaveTheParkingMenu() {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input                -> -1|");
                System.out.println("Go back input                       -> -2|");
                System.out.println("-----------------------------------------|");
                System.out.println("Input number of car to leave the parking |");
                System.out.println("-----------------------------------------|");
                mainMenu.showCarsOnTheParking();

                inputIndex = in.nextLine();

                switch (inputIndex) {
                    case "-1":
                        System.exit(0);
                        break;
                    case "-2":
                        inputParkingOperation();
                        break;
                    default:
                        if (!inputIndex.equals("") && inputIndex.matches("^([1-9][0-9]*|[0])$")) {
                            int carIndex = Integer.parseInt(inputIndex);
                            if (carIndex >= 0 && carIndex < mainMenu.getParkingInstance().getParkingCars().size()) {
                                mainMenu.getParkingInstance().leaveTheParking(carIndex);
                                System.out.println("Car " + mainMenu.getCarListInstance().get(carIndex).getShortInfo() + " left the parking");
                                inputParkingOperation();
                            }
                            else {
                                System.out.println("Such car does not exist on the parking!");
                                openLeaveTheParkingMenu();
                            }
                        }
                        else {
                            System.out.println("You have to input correct number.");
                            openLeaveTheParkingMenu();
                        }
                        break;
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

}
