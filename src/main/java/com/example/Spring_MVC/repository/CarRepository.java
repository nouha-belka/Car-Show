package com.example.Spring_MVC.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spring_MVC.entities.Car;
import com.example.Spring_MVC.enums.VehicleType;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByModel(String model);
    List<Car> findAllByMake(String make);
    List<Car> findAllByVehicleTypeIgnoreCase(VehicleType vehicleType);
}
