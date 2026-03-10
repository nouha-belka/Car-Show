package com.example.Spring_MVC.enums;

public enum VehicleType {
    SUDAN("Sudan"),
    TRUCK("Truck"),
    RV("RV"),
    SUV("SUV");

    private final String name;

    private VehicleType(String name) {

        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    
    
}
