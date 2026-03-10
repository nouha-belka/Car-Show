package com.example.Spring_MVC.utils;

import com.example.Spring_MVC.dto.CarRequest;
import com.example.Spring_MVC.dto.CarResponse;
import com.example.Spring_MVC.entities.Car;
import com.example.Spring_MVC.enums.EngineType;
import com.example.Spring_MVC.enums.VehicleType;

public class CarMapper {

    public static Car fromDto( CarRequest request){
        return new Car(request.carId(),request.make(),request.model(), EngineType.valueOf(request.engineType()) ,request.doorCount(), VehicleType.valueOf(request.vehicleType()), null);
    }
    public static CarResponse toDto( Car car){
        return new CarResponse(car.getCarId(),car.getMake(),car.getModel(), car.getEngineType().toString() ,car.getDoorCount(), car.getVehicleType().toString());
    }
    
}
