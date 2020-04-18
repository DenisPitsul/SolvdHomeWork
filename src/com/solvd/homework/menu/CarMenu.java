package com.solvd.homework.menu;

import com.solvd.homework.factory_method.FactoryMethodCar;
import com.solvd.homework.vehicle.Vehicle;
import com.solvd.homework.vehicle.final_car.AudiA6;
import com.solvd.homework.vehicle.final_car.MercedesVito;
import com.solvd.homework.vehicle.final_car.TeslaSemi;
import com.solvd.homework.vehicle.final_car.ToyotaLandCruiser;
import com.solvd.homework.vehicle.helper.CarModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarMenu {
    private static final String ONLY_LETTERS_REGEX = "^([a-zA-Z]*)$";
    private static final String ONLY_NUMBERS_REGEX = "^([1-9][0-9]*)$";
    private static final String LETTERS_NUMBERS_REGEX = "^[a-zA-Z0-9]*$";

    private Scanner in;
    private MainMenu mainMenu;
    private String inputIndex;

    public CarMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    /**
     * Choose model of car to create or choose 6 to show all created cars on the screen
     * 1 -> Audi A6
     * 2 -> Mercedes Vito
     * 3 -> Toyota Land Cruiser
     * 4 -> Tesla Semi
     * 5 -> Default Car. It will call default method in CarCreator interface
     */
    public void inputCarType() {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Audi A6 input               ->  1|");
                System.out.println("Create Mercedes Vito input         ->  2|");
                System.out.println("Create Toyota Land Cruiser input   ->  3|");
                System.out.println("Create Tesla Semi input            ->  4|");
                System.out.println("Create Default Car(Audi A6) input  ->  5|");
                System.out.println("Show all cars input                ->  6|");

                inputIndex = in.nextLine();

                switch (inputIndex) {
                    case "-1":
                        System.exit(0);
                        break;
                    case "-2":
                        mainMenu.openMainMenu();
                        break;
                    case "1":
                        chooseCreateType(CarModel.AUDI_A6);
                        break;
                    case "2":
                        chooseCreateType(CarModel.MERCEDES_VITO);
                        break;
                    case "3":
                        chooseCreateType(CarModel.TOYOTA_LAND_CRUISER);
                        break;
                    case "4":
                        chooseCreateType(CarModel.TESLA_SEMI);
                        break;
                    case "5":
                        chooseCreateType(CarModel.DEFAULT);
                        break;
                    case "6":
                        mainMenu.showAllCars();
                        mainMenu.openMainMenu();
                        break;
                    default:
                        System.out.println("You have to input number from menu.");
                        inputCarType();
                        break;
                }
                break;
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct number");
            } finally {
                inputCarType();
            }
        }
    }

    /**
     * Choose 1 to create selected car manually
     * Choose 2 to create selected car automatically
     * If we choose 2 car will be created by FactoryMethodCar class
     */
    private void chooseCreateType(CarModel carModel) {
        inputIndex = "";
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create "+ carModel +" manually\t\t\t->  1|");
                System.out.println("Create "+ carModel +" automatically\t\t->  2|");

                inputIndex = in.nextLine();

                switch (inputIndex) {
                    case "-1":
                        System.exit(0);
                        break;
                    case "-2":
                        inputCarType();
                        break;
                    case "1":
                        if (carModel == CarModel.AUDI_A6)
                            createAudiA6Form();
                        else if (carModel == CarModel.MERCEDES_VITO)
                            createMercedesVitoForm();
                        else if (carModel == CarModel.TOYOTA_LAND_CRUISER)
                            createToyotaLandCruiserForm();
                        else if (carModel == CarModel.TESLA_SEMI)
                            createTeslaSemiForm();
                        break;
                    case "2":
                        Vehicle car = FactoryMethodCar.createCar(carModel);
                        mainMenu.getCarListInstance().add(car);
                        inputCarType();
                        break;
                    default:
                        System.out.println("You have to input number from menu.");
                        chooseCreateType(carModel);
                        break;
                }
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct number");
            } finally {
                chooseCreateType(carModel);
            }
        }
    }

    /**
     *  Create Audi A6 manually
     *  Input color of car, car number, max speed and year of the car
     */
    private void createAudiA6Form() {
        AudiA6 audiA6 = new AudiA6();

        String value = "";
        /*
         *  number of iteration in method
         *  0 -> input color
         *  1 -> input car number
         *  2 -> input max speed
         *  3 -> input year of car
         *  4 -> create car
         */
        int propertyNumber = 0;
        while(propertyNumber < 5) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Audi A6                          |");
                System.out.println("----------------------------------------|");
                if(propertyNumber == 0) {
                    System.out.print("Input color: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_LETTERS_REGEX)) {
                                audiA6.setColor(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input color. Color can contains only letters");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 1) {
                    System.out.print("Input car number: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(LETTERS_NUMBERS_REGEX)) {
                                audiA6.setNumber(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input car number. Car number can contains only letters and numbers");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 2) {
                    System.out.print("Input max speed: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_NUMBERS_REGEX)) {
                                audiA6.setMaxSpeed(Integer.parseInt(value));
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input max speed. Max speed can contains only numbers");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 3) {
                    System.out.print("Input year of car: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_NUMBERS_REGEX)) {
                                audiA6.setYear(Integer.parseInt(value));
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input year of car. Year of car can contains only numbers");
                            }
                            break;
                    }
                }
                else {
                    System.out.println("Audi A6 created!");
                    mainMenu.getCarListInstance().add(audiA6);
                    mainMenu.openMainMenu();
                    propertyNumber++;
                }
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct value");
            } finally {
                createAudiA6Form();
            }
        }
    }

    /**
     *  Create Mercedes Vito manually
     *  Input color of car, car number, max speed and year of the car
     */
    private void createMercedesVitoForm() {
        MercedesVito mercedesVito = new MercedesVito();

        String value = "";
        /*
         *  number of iteration in method
         *  0 -> input color
         *  1 -> input car number
         *  2 -> input max speed
         *  3 -> input year of car
         *  4 -> create car
         */
        int propertyNumber = 0;
        while(propertyNumber < 5) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Mercedes Vito                    |");
                System.out.println("----------------------------------------|");
                if(propertyNumber == 0) {
                    System.out.print("Input color: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_LETTERS_REGEX)) {
                                mercedesVito.setColor(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input color. Color can contains only letters");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 1) {
                    System.out.print("Input car number: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(LETTERS_NUMBERS_REGEX)) {
                                mercedesVito.setNumber(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input car number. Car number can contains only letters and numbers");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 2) {
                    System.out.print("Input max speed: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_NUMBERS_REGEX)) {
                                mercedesVito.setMaxSpeed(Integer.parseInt(value));
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input max speed. Max speed can contains only numbers");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 3) {
                    System.out.print("Input year of car: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_NUMBERS_REGEX)) {
                                mercedesVito.setYear(Integer.parseInt(value));
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input year of car. Year of car can contains only numbers");
                            }
                            break;
                    }
                }
                else {
                    System.out.println("Audi A6 created!");
                    mainMenu.getCarListInstance().add(mercedesVito);
                    mainMenu.openMainMenu();
                    propertyNumber++;
                }
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct value");
            } finally {
                createMercedesVitoForm();
            }
        }
    }

    /**
     *  Create Toyota Land Cruiser manually
     *  Input color of car, car number, max speed and year of the car
     */
    private void createToyotaLandCruiserForm() {
        ToyotaLandCruiser toyotaLandCruiser = new ToyotaLandCruiser();

        String value = "";
        /*
         *  number of iteration in method
         *  0 -> input color
         *  1 -> input car number
         *  2 -> input max speed
         *  3 -> input year of car
         *  4 -> create car
         */
        int propertyNumber = 0;
        while(propertyNumber < 5) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Toyota Land Cruiser              |");
                System.out.println("----------------------------------------|");
                if(propertyNumber == 0) {
                    System.out.print("Input color: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_LETTERS_REGEX)) {
                                toyotaLandCruiser.setColor(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input color. Color can contains only letters");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 1) {
                    System.out.print("Input car number: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(LETTERS_NUMBERS_REGEX)) {
                                toyotaLandCruiser.setNumber(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input car number. Car number can contains only letters and numbers");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 2) {
                    System.out.print("Input max speed: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_NUMBERS_REGEX)) {
                                toyotaLandCruiser.setMaxSpeed(Integer.parseInt(value));
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input max speed. Max speed can contains only numbers");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 3) {
                    System.out.print("Input year of car: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_NUMBERS_REGEX)) {
                                toyotaLandCruiser.setYear(Integer.parseInt(value));
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input year of car. Year of car can contains only numbers");
                            }
                            break;
                    }
                }
                else {
                    System.out.println("Audi A6 created!");
                    mainMenu.getCarListInstance().add(toyotaLandCruiser);
                    mainMenu.openMainMenu();
                    propertyNumber++;
                }
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct value");
            } finally {
                createToyotaLandCruiserForm();
            }
        }
    }

    /**
     *  Create Tesla Semi manually
     *  Input color of car, car number, max speed and year of the car
     */
    private void createTeslaSemiForm() {
        TeslaSemi teslaSemi = new TeslaSemi();

        String value = "";
        /*
         *  number of iteration in method
         *  0 -> input color
         *  1 -> input car number
         *  2 -> input max speed
         *  3 -> input year of car
         *  4 -> create car
         */
        int propertyNumber = 0;
        while(propertyNumber < 5) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Tesla Semi                       |");
                System.out.println("----------------------------------------|");
                if(propertyNumber == 0) {
                    System.out.print("Input color: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_LETTERS_REGEX)) {
                                teslaSemi.setColor(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input color. Color can contains only letters");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 1) {
                    System.out.print("Input car number: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(LETTERS_NUMBERS_REGEX)) {
                                teslaSemi.setNumber(value);
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input car number. Car number can contains only letters and numbers");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 2) {
                    System.out.print("Input max speed: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_NUMBERS_REGEX)) {
                                teslaSemi.setMaxSpeed(Integer.parseInt(value));
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input max speed. Max speed can contains only numbers");
                            }
                            break;
                    }
                }
                else if (propertyNumber == 3) {
                    System.out.print("Input year of car: ");
                    value = in.nextLine();

                    switch (value) {
                        case "-1":
                            System.exit(0);
                            break;
                        case "-2":
                            inputCarType();
                            break;
                        default:
                            if (!value.equals("") && value.matches(ONLY_NUMBERS_REGEX)) {
                                teslaSemi.setYear(Integer.parseInt(value));
                                propertyNumber++;
                            }
                            else {
                                System.out.println("You have to input year of car. Year of car can contains only numbers");
                            }
                            break;
                    }
                }
                else {
                    System.out.println("Audi A6 created!");
                    mainMenu.getCarListInstance().add(teslaSemi);
                    mainMenu.openMainMenu();
                    propertyNumber++;
                }
            } catch(InputMismatchException | NumberFormatException e) {
                System.out.println("You have to input correct value");
            } finally {
                createTeslaSemiForm();
            }
        }
    }
}
