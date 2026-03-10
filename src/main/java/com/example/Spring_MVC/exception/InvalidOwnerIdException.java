package com.example.Spring_MVC.exception;

public class InvalidOwnerIdException extends RuntimeException {
    public InvalidOwnerIdException(String s){
        super(s);
    }
}