package com.example.hospitalmanagementsystem.exception.handler;

public class IncorrectPasswordException extends RuntimeException {

    public IncorrectPasswordException(String code, String message) {
        super(message);
    }

}