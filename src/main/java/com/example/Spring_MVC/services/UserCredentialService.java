package com.example.Spring_MVC.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Spring_MVC.repository.UserCredentialRepository;
import com.example.Spring_MVC.dto.UserRequest;
import com.example.Spring_MVC.entities.UserCredentials;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserCredentialService {
    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;

    public String createUser(UserRequest userRequest){
        UserCredentials userCredential = UserCredentials.builder()
            .email(userRequest.email())
            .password(passwordEncoder.encode(userRequest.password()))
            .role("USER")
            .build();
        userCredentialRepository.save(userCredential);

        return "User has been created";
    }
    
}
