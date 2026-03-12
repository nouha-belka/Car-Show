package com.example.Spring_MVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Spring_MVC.dto.CarRequest;
import com.example.Spring_MVC.services.CarService;

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

    @GetMapping(value = {"/create", "/create/"})
    public String carForm(Model model) {
        model.addAttribute(
            "newCar",
            new CarRequest("", "", "", "", (byte) 0) 
        );
        return "car/form";
    }
    
    @PostMapping(value={ "/create", "/create/"})
    public String postMethodName(@ModelAttribute("newCar") CarRequest carRequest, Model model) {
        //TODO: process POST request
        // Here you can handle the submitted data
        // System.out.println("Car Make: " + carRequest.make());
        // System.out.println("Car Model: " + carRequest.model());
        carService.creatCar(carRequest);
        log.info("carIndex: Car Created");
        return "car/success";
    }
    
    
}
