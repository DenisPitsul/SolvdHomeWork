package com.solvd.homework.car_class_hierarchy.menu;

import java.util.Scanner;

public class CarDealershipMenu {
    private Scanner in;
    private MainMenu mainMenu;
    private String inputIndex;

    public CarDealershipMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void inputCarDealershipOperation() {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input                      -> -1|");
                System.out.println("Go back input                             -> -2|");
                System.out.println("-----------------------------------------------|");
                System.out.println("Add Car to car dealership                 ->  1|");
                System.out.println("Leave the car dealership input            ->  2|");
                System.out.println("Show all cars in the car dealership input ->  3|");

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
                            openAddCarDealershipMenu();
                            break;
                        case "2":
                            openLeaveCarFromTheCarDealershipMenu();
                            break;
                        case "3":
                            mainMenu.showCarsInTheCarDealership();
                            inputCarDealershipOperation();
                            break;
                    }
                    break;
                }
                else {
                    System.out.println("You have to input correct number.");
                }
            }
            catch(Exception e) {
                System.out.println("You have to input integer.");
            }
        }
    }

    private void openAddCarDealershipMenu() {
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
                if (inputIndex.equals("-1")) {
                    System.exit(0);
                    break;
                }
                else if (inputIndex.equals("-2")) {
                    inputCarDealershipOperation();
                    break;
                }
                else if (!inputIndex.equals("") && inputIndex.matches("^([1-9][0-9]*|[0])$")) {
                    int carIndex = Integer.parseInt(inputIndex);
                    if (carIndex >= 0 && carIndex < mainMenu.getCarListInstance().size()) {
                        mainMenu.getCarDealershipInstance().add(mainMenu.getCarListInstance().get(carIndex));
                        System.out.println(mainMenu.getCarListInstance().get(carIndex).getShortInfo() + " added to car dealership");
                        inputCarDealershipOperation();
                    }
                    else {
                        System.out.println("Such car does not exist!");
                        openAddCarDealershipMenu();
                    }
                    break;
                }
                else {
                    System.out.println("You have to input correct number.");
                }
            }
            catch(Exception e) {
                System.out.println("You have to input integer.");
            }
        }
    }

    private void openLeaveCarFromTheCarDealershipMenu() {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input                -> -1|");
                System.out.println("Go back input                       -> -2|");
                System.out.println("-----------------------------------------|");
                System.out.println("Input number of car to leave the parking |");
                System.out.println("-----------------------------------------|");
                mainMenu.showCarsInTheCarDealership();

                inputIndex = in.nextLine();
                if (inputIndex.equals("-1")) {
                    System.exit(0);
                    break;
                }
                else if (inputIndex.equals("-2")) {
                    inputCarDealershipOperation();
                    break;
                }
                else if (!inputIndex.equals("") && inputIndex.matches("^([1-9][0-9]*|[0])$")) {
                    int carIndex = Integer.parseInt(inputIndex);
                    if (carIndex >= 0 && carIndex < mainMenu.getParkingInstance().getParkingCars().size()) {
                        mainMenu.getCarDealershipInstance().leaveTheCarDealership(carIndex);
                        System.out.println(mainMenu.getCarListInstance().get(carIndex).getShortInfo() + " left the car dealership");
                        inputCarDealershipOperation();
                    }
                    else {
                        System.out.println("Such car does not exist on the parking!");
                        openLeaveCarFromTheCarDealershipMenu();
                    }
                    break;
                }
                else {
                    System.out.println("You have to input correct number.");
                }
            }
            catch(Exception e) {
                System.out.println("You have to input integer.");
            }
        }
    }

}
