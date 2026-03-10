package com.example.Spring_MVC.services;

import java.util.List;

import com.example.Spring_MVC.dto.CarRequest;
import com.example.Spring_MVC.dto.CarResponse;

public interface CarService {
    CarResponse creatCar(CarRequest car);
    List<CarResponse>  getAllCars();
    CarResponse getCarById(long id);
    List<CarResponse> getCarsByMake(String make);
    List<CarResponse> getCarsByModel(String model);
    List<CarResponse> getCarsByType(String type);
    CarResponse updateCarInformation(CarRequest car);
    void deleteCarById(long id);

}
