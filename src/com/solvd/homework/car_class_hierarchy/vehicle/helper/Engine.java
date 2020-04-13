package com.solvd.homework.car_class_hierarchy.vehicle.helper;

public enum Engine {
    V6_TURBO("V6+Turbo"), V8("V8 4.5"), DIESEL("Diesel 2.2"), ELECTRO("ELECTRO");

    Engine(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
