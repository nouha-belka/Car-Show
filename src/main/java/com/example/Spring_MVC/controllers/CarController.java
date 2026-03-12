package com.example.Spring_MVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        log.info("l20:mjm:carIndex: Loading List of Cars into Model");
        model.addAttribute("listOfCars", carService.getAllCars());
        log.info("l22:mjm:carIndex: List of Cars Loaded");
        return "car/index";
    }
    
}
