package com.solvd.homework.place;

import com.solvd.homework.vehicle.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class Parking<T extends Vehicle> implements CarPlace<T> {
    private List<T> parkingCars;

    public Parking() {
        parkingCars = new LinkedList<>();
    }

    public List<T> getParkingCars() {
        return parkingCars;
    }

    public void setParkingCars(List<T> parkingCars) {
        this.parkingCars = parkingCars;
    }

    /**
     * add car to garage
     * @param car -> will added to this parking
     */
    @Override
    public void add(T car) {
        parkingCars.add(car);
    }

    /**
     * Leave car from the parking
     * @param parkedCar -> car which have to delete from this parking
     * @return deleted car or null if parkedCar weren't in this parking
     */
    @Override
    public T leaveThePlace(T parkedCar) {
        T car = null;
        boolean isCarExist = false;
        for (T eachCar : parkingCars) {
            if (eachCar == parkingCars) {
                car = parkedCar;
                isCarExist = true;
                break;
            }
        }
        if (!isCarExist) {
            return null;
        }
        parkingCars.remove(car);
        return car;
    }

    /**
     * Leave car from the parking by index
     * @param carPlaceIndex -> index of car in car on the parking which have to delete from this parking
     * @return deleted car or null if there is not any cars on the parking by index
     */
    public T leaveTheParking(int carPlaceIndex) {
        if (parkingCars.get(carPlaceIndex) == null) {
            return null;
        }
        return parkingCars.remove(carPlaceIndex);
    }

    /**
     * Show all cars on the parking on the screen
     */
    @Override
    public void showInfo() {
        System.out.println("Parking {");
        for (int i = 0; i < parkingCars.size(); i++) {
            System.out.println("\tPlace №" + i + ": " + parkingCars.get(i).getShortInfo());
        }
        System.out.println("}");
    }

}
