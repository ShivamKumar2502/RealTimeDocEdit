package com.example.RealTimeDocumentEditApplication.authentication.exception;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
