package com.example.Spring_MVC.entities;

import com.example.Spring_MVC.enums.EngineType;
import com.example.Spring_MVC.enums.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long carId;
    private String make;
    private String model;
    private EngineType engineType;
    private byte doorCount;
    private VehicleType vehicleType;

    @ManyToOne
    private Owner owner;

}
