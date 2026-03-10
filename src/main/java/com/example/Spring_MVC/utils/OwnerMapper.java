package com.example.Spring_MVC.utils;

import com.example.Spring_MVC.dto.OwnerRequest;
import com.example.Spring_MVC.dto.OwnerResponse;
import com.example.Spring_MVC.entities.Owner;
import com.example.Spring_MVC.enums.Gender;

public class OwnerMapper {

    public static Owner fromDto( OwnerRequest request){
        return new Owner(request.ownerId(),request.firstName(),request.lastName(), Gender.valueOf(request.gender()) ,request.dateOfBirth(), null);
    }
    public static OwnerResponse toDto( Owner owner){
    return new OwnerResponse(owner.getOwnerId(),owner.getFirstName(),owner.getLastName(), owner.getGender().toString() ,owner.getDateOfBirth());
    }
    
}
