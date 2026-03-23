package com.example.Spring_MVC.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Spring_MVC.dto.OwnerRequest;
import com.example.Spring_MVC.dto.OwnerResponse;
import com.example.Spring_MVC.enums.Gender;
import com.example.Spring_MVC.services.OwnerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

@Slf4j
@Controller
@RequestMapping("owner")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;
    
    // @GetMapping(value = {"/", ""})
    // public String OwnerIndex(Model model) {
    //     log.info("ownerIndex: Loading List of Owners into Model");
    //     model.addAttribute("listOfOwners", ownerService.getAllOwners());
    //     log.info("ownerIndex: List of Owners Loaded");
    //     return "owner/index";
    // }

    // @PostMapping("/delete")
    // public String deleteOwner(@RequestParam(value = "ownerId") long ownerId) {
    //     log.info("deleteOwner: deleting owner with id {}", ownerId);
    //     ownerService.deleteOwnerById(ownerId);
    //     return "redirect:/owner";
    // }

    // @GetMapping(value = {"/create", "/create/"})
    // public String ownerForm(Model model) {
    //     model.addAttribute(
    //         "newOwner",
    //         new OwnerRequest("", "", "", null) 
    //     );
    //     model.addAttribute("genders", Gender.values());
    //     return "owner/form";
    // }
    
    // @PostMapping(value={ "/create", "/create/"})
    // public String postMethodName(@Valid @ModelAttribute("newOwner") OwnerRequest ownerRequest, BindingResult bindingResult, Model model) {
    //     // Add enum values to model for form redisplay if validation fails
    //     model.addAttribute("genders", Gender.values());
        
    //     if (bindingResult.hasErrors()) {
    //         log.warn("Validation errors occurred while creating owner: {}", bindingResult.getAllErrors());
    //         return "owner/form";
    //     }
        
    //     ownerService.creatOwner(ownerRequest);
    //     log.info("ownerIndex: Owner Created");
    //     return "owner/success";
    // }

    @GetMapping(value = {"/", ""})
    public ResponseEntity<List<OwnerResponse>> ownerIndex(){
        return ResponseEntity.ok(ownerService.getAllOwners());
    }

    @PostMapping(value = {"/create", "/create/"})
    public ResponseEntity<OwnerResponse> createOwner(@Valid @RequestBody OwnerRequest ownerRequest){
        return ResponseEntity.created(null).body(ownerService.creatOwner(ownerRequest));
    }

    @PutMapping(value = {"/{id}/update"})
    public ResponseEntity<OwnerResponse> updateOwnerRequest(@Valid @RequestBody OwnerRequest ownerRequest) {
        return ResponseEntity.created(null).body(ownerService.creatOwner(ownerRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable long id){
        ownerService.deleteOwnerById(id);
        return ResponseEntity.ok().build();
    }
    
}
