package com.solvd.homework.menu;


import com.solvd.homework.place.*;
import com.solvd.homework.vehicle.interfaces.Car;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private List<Car> carList;
    private Parking parking;
    private CarDealership carDealership;
    private Homes homes;

    private CarMenu carMenu;
    private ParkingMenu parkingMenu;
    private CarDealershipMenu carDealershipMenu;
    private HomesMenu homesMenu;

    private Scanner in;

    public MainMenu() {
    }

    private CarMenu getCarMenuInstance() {
        if (carMenu == null) {
            carMenu = new CarMenu(this);
        }
        return carMenu;
    }

    private ParkingMenu getParkingMenuInstance() {
        if (parkingMenu == null) {
            parkingMenu = new ParkingMenu(this);
        }
        return parkingMenu;
    }

    private CarDealershipMenu getCarDealershipMenuInstance() {
        if (carDealershipMenu == null) {
            carDealershipMenu = new CarDealershipMenu(this);
        }
        return carDealershipMenu;
    }

    private HomesMenu getHomesMenuInstance() {
        if (homesMenu == null) {
            homesMenu = new HomesMenu(this);
        }
        return homesMenu;
    }

    public List<Car> getCarListInstance() {
        if (carList == null) {
            carList = new LinkedList<>();
        }
        return carList;
    }

    public Parking getParkingInstance() {
        if (parking == null) {
            parking = new Parking();
        }
        return parking;
    }

    public CarDealership getCarDealershipInstance() {
        if (carDealership == null) {
            carDealership = new CarDealership();
        }
        return carDealership;
    }

    public Homes getHomesInstance() {
        if (homes == null) {
            homes = new Homes();
        }
        return homes;
    }

    public void showAllCars() {
        if (carList == null || carList.size() == 0) {
            System.out.println("There is not any car!");
            openMainMenu();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("All cars {\n");
        int i = 0;
        for (Car car : carList) {
            sb.append("\tCar №").append(i).append(": ").append(car.getShortInfo()).append("\n");
            i++;
        }
        sb.append('}');
        System.out.println(sb.toString());
    }

    public void showCarsOnTheParking() {
        if (getParkingInstance().getParkingCars() == null || getParkingInstance().getParkingCars().size() == 0) {
            System.out.println("There is not any car on the parking!");
            openParkingMenu();
            return;
        }
        parking.showInfo();
    }

    public void showCarsInTheCarDealership() {
        if (getCarDealershipInstance().getSellingCars() == null || getCarDealershipInstance().getSellingCars().size() == 0) {
            System.out.println("There is not any car in the car dealership!");
            openCarDealership();
            return;
        }
        carDealership.showInfo();
    }

    public void showAllHomes() {
        if (getHomesInstance().getHomes() == null || getHomesInstance().getHomes().size() == 0) {
            System.out.println("There is not any homes!");
            openHomeMenu();
            return;
        }
        homes.showInfo();
    }

    public void openMainMenu() {
        int menuIndex;
        while(true) {
            try {
                in = new Scanner(System.in);

                System.out.println("-------------M A I N  P A G E------------");
                System.out.println("Finish program input               -> -1|");
                System.out.println("----------------------------------------|");
                System.out.println("Car menu input                     ->  1|");
                System.out.println("Parking menu input                 ->  2|");
                System.out.println("Car dealership menu input          ->  3|");
                System.out.println("Home menu input                    ->  4|");

                menuIndex = in.nextInt();
                if (menuIndex == 10) {
                    System.exit(0);
                    break;
                }
                else if (menuIndex >= 1 && menuIndex <= 4) {
                    switch (menuIndex) {
                        case 1:
                            openCarMenu();
                            break;
                        case 2:
                            openParkingMenu();
                            break;
                        case 3:
                            openCarDealership();
                            break;
                        case 4:
                            openHomeMenu();
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

    private void openCarMenu() {
        CarMenu carMenu = getCarMenuInstance();
        carMenu.inputCarType();
    }

    private void openParkingMenu() {
        ParkingMenu parkingMenu = getParkingMenuInstance();
        parkingMenu.inputParkingOperation();
    }

    private void openCarDealership() {
        CarDealershipMenu carDealershipMenu = getCarDealershipMenuInstance();
        carDealershipMenu.inputCarDealershipOperation();
    }

    private void openHomeMenu() {
        HomesMenu homesMenu = getHomesMenuInstance();
        homesMenu.inputHomesOperation();
    }

}
