package com.example.Spring_MVC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring_MVC.entities.UserCredentials;

@Repository
public interface  UserCredentialRepository extends JpaRepository<UserCredentials, Long> {
    Optional<UserCredentials> findByEmail(String username);
}
