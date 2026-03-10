package com.example.Spring_MVC.entities;

import java.time.LocalDate;
import java.util.List;

import com.example.Spring_MVC.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ownerId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="owner")
    private List<Car> cars;
    
    

}
