package com.example.Spring_MVC.exception;

public class InvalidCarIdException extends RuntimeException {
    public InvalidCarIdException(String s){
        super(s);
    }
}
