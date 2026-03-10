package com.example.Spring_MVC.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.Spring_MVC.entities.Car;
import com.example.Spring_MVC.entities.Owner;
import com.example.Spring_MVC.enums.EngineType;
import com.example.Spring_MVC.enums.Gender;
import com.example.Spring_MVC.enums.VehicleType;
import com.example.Spring_MVC.repository.CarRepository;
import com.example.Spring_MVC.repository.OwnerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
@Profile("!prod")
public class DbInit implements CommandLineRunner {
    private final OwnerRepository ownerRepository;
    private final CarRepository carRepository;

    @Override
    public void run(String ...args){
        if(ownerRepository.count() > 0){
            log.info("Database already seeded, skipping init");
            return;
        }

        // Owners
        Owner owner1 = new Owner();
        owner1.setFirstName("Alice");
        owner1.setLastName("Johnson");
        owner1.setGender(Gender.FEMALE);
        owner1.setDateOfBirth(LocalDate.of(1990, 5, 12));

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Brown");
        owner2.setGender(Gender.MALE);
        owner2.setDateOfBirth(LocalDate.of(1985, 8, 23));

        Owner owner3 = new Owner();
        owner3.setFirstName("Sophia");
        owner3.setLastName("Garcia");
        owner3.setGender(Gender.FEMALE);
        owner3.setDateOfBirth(LocalDate.of(1995, 2, 2));

        ownerRepository.saveAll(List.of(owner1, owner2, owner3));

        // Cars
        Car car1 = new Car();
        car1.setMake("Toyota");
        car1.setModel("Camry");
        car1.setEngineType(EngineType.V6_ENGINE);
        car1.setDoorCount((byte)4);
        car1.setVehicleType(VehicleType.RV);
        car1.setOwner(owner1);

        Car car2 = new Car();
        car2.setMake("Tesla");
        car2.setModel("Model 3");
        car2.setEngineType(EngineType.V8_ENGINE);
        car2.setDoorCount((byte)4);
        car2.setVehicleType(VehicleType.SUDAN);
        car2.setOwner(owner1);

        Car car3 = new Car();
        car3.setMake("Ford");
        car3.setModel("F-150");
        car3.setEngineType(EngineType.V8_ENGINE);
        car3.setDoorCount((byte)2);
        car3.setVehicleType(VehicleType.TRUCK);
        car3.setOwner(owner2);

        Car car4 = new Car();
        car4.setMake("Honda");
        car4.setModel("CR-V");
        car4.setEngineType(EngineType.V8_ENGINE);
        car4.setDoorCount((byte)4);
        car4.setVehicleType(VehicleType.SUV);
        car4.setOwner(owner3);

        carRepository.saveAll(List.of(car1, car2, car3, car4));

        log.info("Database seeding completed");
    }
}
