package com.solvd.homework.menu;

import com.solvd.homework.dao.AddressDAO;
import com.solvd.homework.dao.ParkingDAO;
import com.solvd.homework.exception.TruckOnParkingException;
import com.solvd.homework.vehicle.Truck;
import com.solvd.homework.vehicle.Vehicle;

import java.util.InputMismatchException;
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
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct number.");
            } finally {
                inputParkingOperation();
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
                        if (!inputIndex.equals("")) {
                            int carIndex = Integer.parseInt(inputIndex);
                            if (carIndex >= 0 && carIndex < mainMenu.getCarListInstance().size()) {
                                Vehicle vehicle = mainMenu.getCarListInstance().get(carIndex);
                                if (vehicle instanceof Truck) {
                                    throw new TruckOnParkingException();
                                }
                                else {
                                    mainMenu.getParkingInstance().add(vehicle);
                                    mainMenu.getParkingDAO().writeToFile(vehicle);
                                    System.out.println("Car " + vehicle.getShortInfo() + " has parked");
                                    inputParkingOperation();
                                }

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
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct number.");
            } catch (TruckOnParkingException e) {
                System.out.println(e.getMessage());;
            } finally {
                inputParkingOperation();
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
                        if (!inputIndex.equals("")) {
                            int carIndex = Integer.parseInt(inputIndex);
                            if (carIndex >= 0 && carIndex < mainMenu.getParkingInstance().getParkingCars().size()) {
                                mainMenu.getParkingInstance().leaveTheParking(carIndex);
                                mainMenu.getParkingDAO().clearFile();
                                mainMenu.getParkingDAO().writeAllToFile(mainMenu.getParkingInstance());
                                Vehicle vehicle = mainMenu.getCarListInstance().get(carIndex);
                                System.out.println("Car " + vehicle.getShortInfo() + " left the parking");
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
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct number.");
            } finally {
                openLeaveTheParkingMenu();
            }
        }
    }

}
