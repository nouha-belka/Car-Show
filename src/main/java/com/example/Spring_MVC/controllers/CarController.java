package com.example.Spring_MVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Spring_MVC.dto.CarRequest;
import com.example.Spring_MVC.enums.EngineType;
import com.example.Spring_MVC.enums.VehicleType;
import com.example.Spring_MVC.services.CarService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@Controller
@RequestMapping("car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    
    @GetMapping(value = {"/", ""})
    public String CarIndex(Model model) {
        log.info("carIndex: Loading List of Cars into Model");
        model.addAttribute("listOfCars", carService.getAllCars());
        log.info("carIndex: List of Cars Loaded");
        return "car/index";
    }

    @PostMapping("/delete")
    public String deleteCar(@RequestParam(value = "carId") long carId) {
        log.info("deleteCar: deleting car with id {}", carId);
        carService.deleteCarById(carId);
        return "redirect:/car";
    }

    @GetMapping(value = {"/create", "/create/"})
    public String carForm(Model model) {
        model.addAttribute(
            "newCar",
            new CarRequest("", "", "", "", (byte) 0) 
        );
        model.addAttribute("engineTypes", EngineType.values());
        model.addAttribute("vehicleTypes", VehicleType.values());
        return "car/form";
    }
    
    @PostMapping(value={ "/create", "/create/"})
    public String postMethodName(@Valid @ModelAttribute("newCar") CarRequest carRequest, BindingResult bindingResult, Model model) {
        // Add enum values to model for form redisplay if validation fails
        model.addAttribute("engineTypes", EngineType.values());
        model.addAttribute("vehicleTypes", VehicleType.values());
        
        if (bindingResult.hasErrors()) {
            log.warn("Validation errors occurred while creating car: {}", bindingResult.getAllErrors());
            return "car/form";
        }
        
        carService.creatCar(carRequest);
        log.info("carIndex: Car Created");
        return "car/success";
    }
    
    
}
