package com.example.Spring_MVC.exception;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExcepptionHandler {
    @ExceptionHandler(InvalidCarIdException.class)
    public ModelAndView handleException(Exception e, HttpServletRequest request, HttpServletResponse response){
        ModelAndView error = new ModelAndView();
        error.addObject("Error Message", e.getMessage());
        error.addObject("URL Path", request.getRequestURI());
        error.addObject("timestamp", LocalDate.now());
        return error;
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView catchAll(Exception e, HttpServletRequest request, HttpServletResponse response){
        ModelAndView error = new ModelAndView("error");
        error.addObject("errorMessage", e.getMessage());
        error.addObject("urlPath", request.getRequestURI());
        error.addObject("timestamp", LocalDate.now());
        return error;
    }
}
