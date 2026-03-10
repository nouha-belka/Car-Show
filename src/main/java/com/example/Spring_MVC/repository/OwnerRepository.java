package com.example.Spring_MVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring_MVC.entities.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner> findAllByFirstName(String firstName);
    List<Owner> findAllByLastName(String lastName);   
}
