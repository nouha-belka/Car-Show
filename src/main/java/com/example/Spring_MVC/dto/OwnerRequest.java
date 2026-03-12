package com.example.Spring_MVC.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public record OwnerRequest(
    long ownerId,
    
    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[A-Za-z]{2,}$", message = "First name must be at least 2 characters and contain only letters")
    String firstName,
    
    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "^[A-Za-z]{2,}$", message = "Last name must be at least 2 characters and contain only letters")
    String lastName,
    
    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "MALE|FEMALE|OTHER", message = "Invalid gender. Must be MALE, FEMALE, or OTHER")
    String gender,
    
    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    LocalDate dateOfBirth
){
    public OwnerRequest(String firstName, String lastName, String gender, LocalDate dateOfBirth){
        this(0,firstName, lastName, gender, dateOfBirth);
    }
}