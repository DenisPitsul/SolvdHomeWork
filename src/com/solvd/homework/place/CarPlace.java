package com.solvd.homework.place;

import com.solvd.homework.vehicle.Vehicle;

public interface CarPlace<T extends Vehicle> {
    void add(T car);
    T leaveThePlace(T car);
    void showInfo();
}
