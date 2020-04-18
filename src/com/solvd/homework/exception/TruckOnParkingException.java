package com.solvd.homework.exception;

public class TruckOnParkingException extends Exception {

    @Override
    public String getMessage() {
        return "You can't park truck!";
    }
}
