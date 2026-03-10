package com.example.Spring_MVC.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Spring_MVC.dto.CarRequest;
import com.example.Spring_MVC.dto.CarResponse;
import com.example.Spring_MVC.entities.Car;
import com.example.Spring_MVC.enums.VehicleType;
import com.example.Spring_MVC.exception.InvalidCarIdException;
import com.example.Spring_MVC.repository.CarRepository;
import com.example.Spring_MVC.utils.CarMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository CarRepository;

    @Override
    public CarResponse creatCar(CarRequest carRequest) {
        Car car = CarMapper.fromDto(carRequest);
        return CarMapper.toDto(CarRepository.save(car));
    }

    @Override
    public List<CarResponse> getAllCars() {
        return CarRepository.findAll().stream().map(CarMapper::toDto).toList();
    }

    @Override
    public CarResponse getCarById(long id) {
        return CarMapper.toDto(
            CarRepository.findById(id).orElseThrow(
                () -> new InvalidCarIdException("Car id" + id + "not found !")
            )
        );
    }

    @Override
    public List<CarResponse> getCarsByMake(String make) {
        return CarRepository.findAllByMake(make).stream().map(CarMapper::toDto).toList();
    }

    @Override
    public List<CarResponse> getCarsByModel(String model) {
        return CarRepository.findAllByModel(model).stream().map(CarMapper::toDto).toList();
    }

    @Override
    public List<CarResponse> getCarsByType(String type) {
        return CarRepository
        .findAllByVehicleTypeIgnoreCase(VehicleType.valueOf(type))
        .stream()
        .map(CarMapper::toDto).toList();
    }

    @Override
    public CarResponse updateCarInformation(CarRequest carRequest) {
        Car newCarInfo = CarMapper.fromDto(carRequest);
        if(CarRepository.existsById(newCarInfo.getCarId())){
            return CarMapper.toDto(CarRepository.save(newCarInfo));
        }

        return null;
    }

    @Override
    public void deleteCarById(long id) {
        if( !CarRepository.existsById(id)){
            throw new InvalidCarIdException("Car id" + id + "not found !");
        }
        CarRepository.deleteById(id);
    }
    
}
