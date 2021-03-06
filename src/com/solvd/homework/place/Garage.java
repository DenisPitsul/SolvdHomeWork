package com.solvd.homework.place;

import com.solvd.homework.vehicle.Vehicle;

import java.util.HashSet;
import java.util.Set;

public class Garage<T extends Vehicle> implements CarPlace<T> {
    private Set<T> carsInGarage;
    private boolean isBig;

    private boolean isBigGarageValueSetted = false;

    public Garage() {
        carsInGarage = new HashSet<>();
        isBig = false;
    }

    public Set<T> getCarsInGarage() {
        return carsInGarage;
    }

    public void setCarsInGarage(Set<T> carsInGarage) {
        this.carsInGarage = carsInGarage;
    }

    public boolean isBig() {
        return isBig;
    }

    /**
     * if isBig value already setted you can not set it again
     * @param isBig -> if garage big isBig = true else if garage small isBig = false
     */
    public void setBig(boolean isBig) {
        if (!isBigGarageValueSetted) {
            this.isBig = isBig;
            isBigGarageValueSetted = true;
        }
    }

    public boolean isBigGarageValueSetted() {
        return isBigGarageValueSetted;
    }

    /**
     * add car to garage
     * @param car -> will added to this garage
     */
    @Override
    public void add(T car) {
        carsInGarage.add(car);
    }

    /**
     * Leave car from the car dealership
     * @param carInGarage -> car which have to delete from this garage
     * @return deleted car or null if selectedCar weren't in this garage
     */
    @Override
    public T leaveThePlace(T carInGarage) {
        T car = null;
        boolean isCarExist = false;
        for (T eachCar : carsInGarage) {
            if (eachCar == carInGarage) {
                car = carInGarage;
                isCarExist = true;
                break;
            }
        }
        if (!isCarExist) {
            return null;
        }
        carsInGarage.remove(car);
        return (T) car;
    }

    /**
     * Show all cars in the garage on the screen
     */
    @Override
    public void showInfo() {
        System.out.println("Garage {");
        System.out.println("\tGarage is " + (isBig ? "big" : "small"));
        int i = 0;
        for (T car : carsInGarage) {
            System.out.println("\tCar №" + i + ": " + car.getShortInfo());
            i++;
        }
        System.out.println("}");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tGarage {\n");
        sb.append("\t\t\tGarage is ").append(isBig ? "big" : "small").append("\n");
        int i = 0;
        for (T car : carsInGarage) {
            sb.append("\t\t\tCar #").append(i).append(": ").append(car.getShortInfo()).append("\n");
            i++;
        }
        sb.append("\t\t}");
        return sb.toString();
    }
}
