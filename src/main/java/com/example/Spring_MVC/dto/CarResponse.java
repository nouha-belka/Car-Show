package com.example.Spring_MVC.dto;


public record CarResponse(
    long carId,  
    String make,
    String model,
    String engineType,
    byte doorCount,
    String vehicleType
) {

}
