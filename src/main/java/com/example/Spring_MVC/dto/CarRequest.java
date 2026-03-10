package com.example.Spring_MVC.dto;
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @ToString
// public class CarRequest {

//     private String make;
//     private String model;
//     private EngineType engineType;
//     private byte doorCount;
//     private VehicleType vehicleType;

// }


public record CarRequest(
    long carId,  
    String make,
    String model,
    String engineType,
    byte doorCount,
    String vehicleType
){
    public CarRequest(String make, String model, String engineType, String vehicleType, byte doorCount){
        this(0,make, model, engineType, doorCount, vehicleType);
    }
}