package com.solvd.homework.exception;

public class TruckOnParkingException extends Exception {
    private static final String MESSAGE = "You can't park truck!";

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
