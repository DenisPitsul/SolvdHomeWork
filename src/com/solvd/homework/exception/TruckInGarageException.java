package com.solvd.homework.exception;

public class TruckInGarageException extends Exception {

    @Override
    public String getMessage() {
        return "You can't add truck in small garage!";
    }
}
