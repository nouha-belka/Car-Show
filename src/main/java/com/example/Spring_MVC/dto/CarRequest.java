package com.example.Spring_MVC.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CarRequest(
    long carId,  
    
    @NotBlank(message = "Make is required")
    @Pattern(regexp = "^[A-Za-z\\s]{2,}$", message = "Make must be at least 2 characters and contain only letters")
    String make,
    
    @NotBlank(message = "Model is required")
    @Pattern(regexp = "^[A-Za-z0-9\\s-]{2,}$", message = "Model must be at least 2 characters")
    String model,
    
    @NotBlank(message = "Engine type is required")
    @Pattern(regexp = "V6_ENGINE|V8_ENGINE", message = "Invalid engine type. Must be V6_ENGINE or V8_ENGINE")
    String engineType,
    
    @Min(value = 1, message = "Door count must be at least 1")
    @Max(value = 10, message = "Door count cannot exceed 10")
    byte doorCount,
    
    @NotBlank(message = "Vehicle type is required")
    @Pattern(regexp = "SUDAN|TRUCK|SUV|RV", message = "Invalid vehicle type. Must be SUDAN, TRUCK, SUV, or RV")
    String vehicleType
){
    public CarRequest(String make, String model, String engineType, String vehicleType, byte doorCount){
        this(0,make, model, engineType, doorCount, vehicleType);
    }
}