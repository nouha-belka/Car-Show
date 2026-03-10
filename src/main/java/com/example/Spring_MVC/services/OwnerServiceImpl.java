package com.example.Spring_MVC.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Spring_MVC.dto.OwnerRequest;
import com.example.Spring_MVC.dto.OwnerResponse;
import com.example.Spring_MVC.entities.Owner;
import com.example.Spring_MVC.enums.Gender;
import com.example.Spring_MVC.exception.InvalidOwnerIdException;
import com.example.Spring_MVC.repository.OwnerRepository;
import com.example.Spring_MVC.utils.OwnerMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Override
    public OwnerResponse creatOwner(OwnerRequest ownerRequest) {
        Owner owner = OwnerMapper.fromDto(ownerRequest);
        return OwnerMapper.toDto(ownerRepository.save(owner));
    }

    @Override
    public List<OwnerResponse> getAllOwners() {
        return ownerRepository.findAll().stream().map(OwnerMapper::toDto).toList();
    }

    @Override
    public OwnerResponse getOwnerById(long id) {
        return OwnerMapper.toDto(
            ownerRepository.findById(id).orElseThrow(
                () -> new InvalidOwnerIdException("Owner id" + id + "not found !")
            )
        );
    }

    @Override
    public List<OwnerResponse> getOwnersByGender(String gender) {
        return ownerRepository
        .findAllByGenderIgnoreCase(Gender.valueOf(gender))
        .stream()
        .map(OwnerMapper::toDto).toList();
    }

    @Override
    public List<OwnerResponse> getOwnersByFirstName(String firstName) {
        return ownerRepository.findAllByFirstName(firstName).stream().map(OwnerMapper::toDto).toList();
    }

    @Override
    public List<OwnerResponse> getOwnersByLastName(String lastName) {
        return ownerRepository.findAllByLastName(lastName).stream().map(OwnerMapper::toDto).toList();
    }

    @Override
    public OwnerResponse updateOwnerInformation(OwnerRequest ownerRequest) {
        Owner newOwnerInfo = OwnerMapper.fromDto(ownerRequest);
        if(ownerRepository.existsById(newOwnerInfo.getOwnerId())){
            return OwnerMapper.toDto(ownerRepository.save(newOwnerInfo));
        }

        return null;
    }

    @Override
    public void deleteOwnerById(long id) {
        if( !ownerRepository.existsById(id)){
            throw new InvalidOwnerIdException("Owner id" + id + "not found !");
        }
        ownerRepository.deleteById(id);
    }
    
}
