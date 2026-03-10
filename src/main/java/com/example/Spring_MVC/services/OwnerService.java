package com.example.Spring_MVC.services;

import java.util.List;

import com.example.Spring_MVC.dto.OwnerRequest;
import com.example.Spring_MVC.dto.OwnerResponse;

public interface OwnerService {
    OwnerResponse creatOwner(OwnerRequest owner);
    List<OwnerResponse>  getAllOwners();
    OwnerResponse getOwnerById(long id);
    List<OwnerResponse> getOwnersByGender(String gender);
    List<OwnerResponse> getOwnersByFirstName(String firstName);
    List<OwnerResponse> getOwnersByLastName(String lastName);
    OwnerResponse updateOwnerInformation(OwnerRequest owner);
    void deleteOwnerById(long id);

}
