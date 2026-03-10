package com.example.Spring_MVC.dto;

import java.time.LocalDate;

public record OwnerResponse(
    long ownerId,
    String firstName,
    String lastName,
    String gender,
    LocalDate dateOfBirth
) {
    
}
