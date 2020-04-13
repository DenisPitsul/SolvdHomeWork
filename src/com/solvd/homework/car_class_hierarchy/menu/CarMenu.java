package com.solvd.homework.car_class_hierarchy.menu;

import com.solvd.homework.car_class_hierarchy.factory_method.FactoryMethodCar;
import com.solvd.homework.car_class_hierarchy.vehicle.final_car.AudiA6;
import com.solvd.homework.car_class_hierarchy.vehicle.final_car.MercedesVito;
import com.solvd.homework.car_class_hierarchy.vehicle.final_car.TeslaSemi;
import com.solvd.homework.car_class_hierarchy.vehicle.final_car.ToyotaLandCruiser;
import com.solvd.homework.car_class_hierarchy.vehicle.helper.CarModel;
import com.solvd.homework.car_class_hierarchy.vehicle.interfaces.Car;

import java.util.Scanner;

public class CarMenu {
    private Scanner in;
    private MainMenu mainMenu;
    private String inputIndex;

    public CarMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

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
                System.out.println("Show all cars input                ->  5|");

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
                            mainMenu.showAllCars();
                            mainMenu.openMainMenu();
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
                if (inputIndex.equals("-1")) {
                    System.exit(0);
                    break;
                }
                else if (inputIndex.equals("-2")) {
                    inputCarType();
                    break;
                }
                else if (inputIndex.equals("1")) {
                    switch (carModel) {
                        case AUDI_A6:
                            createAudiA6Form();
                            break;
                        case MERCEDES_VITO:
                            createMercedesVitoForm();
                            break;
                        case TOYOTA_LAND_CRUISER:
                            createToyotaLandCruiserForm();
                            break;
                        case TESLA_SEMI:
                            createTeslaSemiForm();
                            break;
                    }
                }
                else if (inputIndex.equals("2")) {
                    Car car = FactoryMethodCar.createCar(carModel);
                    mainMenu.getCarListInstance().add(car);
                    inputCarType();
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

    private void createAudiA6Form() {
        AudiA6 audiA6 = new AudiA6();

        String value = "";
        int i = 0;
        while(true && i < 5) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Audi A6                          |");
                System.out.println("----------------------------------------|");
                if(i == 0) {
                    System.out.print("Input color: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^[a-zA-Z]*$")) {
                        audiA6.setColor(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input color!");
                    }
                }
                else if (i == 1) {
                    System.out.print("Input car number: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^[a-zA-Z0-9]*$")) {
                        audiA6.setNumber(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input car number!");
                    }
                }
                else if (i == 2) {
                    System.out.print("Input max speed: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^([1-9][0-9]*)$")) {
                        audiA6.setMaxSpeed(Integer.parseInt(value));
                        i++;
                    }
                    else {
                        System.out.println("You have to input max speed!");
                    }
                }
                else if (i == 3) {
                    System.out.print("Input year of car: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^([1-9][0-9]*)$")) {
                        audiA6.setYear(Integer.parseInt(value));
                        i++;
                    }
                    else {
                        System.out.println("You have to input year of car!");
                    }
                }
                else {
                    System.out.println("Audi A6 created!");
                    mainMenu.getCarListInstance().add(audiA6);
                    mainMenu.openMainMenu();
                    i++;
                }
            }
            catch(Exception e) {
                System.out.println("Input correct value!");
            }
        }
    }

    private void createMercedesVitoForm() {
        MercedesVito mercedesVito = new MercedesVito();

        String value = "";
        int i = 0;
        while(true && i < 5) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Mercedes Vito                    |");
                System.out.println("----------------------------------------|");
                if(i == 0) {
                    System.out.print("Input color: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^[a-zA-Z]*$")) {
                        mercedesVito.setColor(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input color!");
                    }
                }
                else if (i == 1) {
                    System.out.print("Input car number: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^[a-zA-Z0-9]*$")) {
                        mercedesVito.setNumber(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input car number!");
                    }
                }
                else if (i == 2) {
                    System.out.print("Input max speed: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^([1-9][0-9]*)$")) {
                        mercedesVito.setMaxSpeed(Integer.parseInt(value));
                        i++;
                    }
                    else {
                        System.out.println("You have to input max speed!");
                    }
                }
                else if (i == 3) {
                    System.out.print("Input year of car: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^([1-9][0-9]*)$")) {
                        mercedesVito.setYear(Integer.parseInt(value));
                        i++;
                    }
                    else {
                        System.out.println("You have to input year of car!");
                    }
                }
                else {
                    System.out.println("Mercedes Vito created!");
                    mainMenu.getCarListInstance().add(mercedesVito);
                    mainMenu.openMainMenu();
                    i++;
                }
            }
            catch(Exception e) {
                System.out.println("Input correct value!");
            }
        }
    }

    private void createToyotaLandCruiserForm() {
        ToyotaLandCruiser toyotaLandCruiser = new ToyotaLandCruiser();

        String value = "";
        int i = 0;
        while(true && i < 5) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Toyota Land Cruiser              |");
                System.out.println("----------------------------------------|");
                if(i == 0) {
                    System.out.print("Input color: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^[a-zA-Z]*$")) {
                        toyotaLandCruiser.setColor(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input color!");
                    }
                }
                else if (i == 1) {
                    System.out.print("Input car number: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^[a-zA-Z0-9]*$")) {
                        toyotaLandCruiser.setNumber(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input car number!");
                    }
                }
                else if (i == 2) {
                    System.out.print("Input max speed: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^([1-9][0-9]*)$")) {
                        toyotaLandCruiser.setMaxSpeed(Integer.parseInt(value));
                        i++;
                    }
                    else {
                        System.out.println("You have to input max speed!");
                    }
                }
                else if (i == 3) {
                    System.out.print("Input year of car: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^([1-9][0-9]*)$")) {
                        toyotaLandCruiser.setYear(Integer.parseInt(value));
                        i++;
                    }
                    else {
                        System.out.println("You have to input year of car!");
                    }
                }
                else {
                    System.out.println("Mercedes Vito created!");
                    mainMenu.getCarListInstance().add(toyotaLandCruiser);
                    mainMenu.openMainMenu();
                    i++;
                }
            }
            catch(Exception e) {
                System.out.println("Input correct value!");
            }
        }
    }

    private void createTeslaSemiForm() {
        TeslaSemi teslaSemi = new TeslaSemi();

        String value = "";
        int i = 0;
        while(true && i < 5) {
            try {
                in = new Scanner(System.in);

                System.out.println("Finish program input               -> -1|");
                System.out.println("Go back input                      -> -2|");
                System.out.println("----------------------------------------|");
                System.out.println("Create Tesla Semi                       |");
                System.out.println("----------------------------------------|");
                if(i == 0) {
                    System.out.print("Input color: ");
                    value = in.nextLine();
                    if (value.equals("-1")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("-2")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^[a-zA-Z]*$")) {
                        teslaSemi.setColor(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input color!");
                    }
                }
                else if (i == 1) {
                    System.out.print("Input car number: ");
                    value = in.nextLine();
                    if (value.equals("10")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("11")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^[a-zA-Z0-9]*$")) {
                        teslaSemi.setNumber(value);
                        i++;
                    }
                    else {
                        System.out.println("You have to input car number!");
                    }
                }
                else if (i == 2) {
                    System.out.print("Input max speed: ");
                    value = in.nextLine();
                    if (value.equals("10")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("11")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^([1-9][0-9]*)$")) {
                        teslaSemi.setMaxSpeed(Integer.parseInt(value));
                        i++;
                    }
                    else {
                        System.out.println("You have to input max speed!");
                    }
                }
                else if (i == 3) {
                    System.out.print("Input year of car: ");
                    value = in.nextLine();
                    if (value.equals("10")) {
                        System.exit(0);
                        break;
                    }
                    else if (value.equals("11")) {
                        inputCarType();
                        break;
                    }
                    else if (!value.equals("") && value.matches("^([1-9][0-9]*)$")) {
                        teslaSemi.setYear(Integer.parseInt(value));
                        i++;
                    }
                    else {
                        System.out.println("You have to input year of car!");
                    }
                }
                else {
                    System.out.println("Mercedes Vito created!");
                    mainMenu.getCarListInstance().add(teslaSemi);
                    mainMenu.openMainMenu();
                    i++;
                }
            }
            catch(Exception e) {
                System.out.println("Input correct value!");
            }
        }
    }
}
