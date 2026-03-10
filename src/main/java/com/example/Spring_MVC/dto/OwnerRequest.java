package com.example.Spring_MVC.dto;

import java.time.LocalDate;

public record OwnerRequest(
    long ownerId,
    String firstName,
    String lastName,
    String gender,
    LocalDate dateOfBirth
){
    public OwnerRequest(String firstName, String lastName, String gender, LocalDate dateOfBirth){
        this(0,firstName, lastName, gender, dateOfBirth);
    }
}