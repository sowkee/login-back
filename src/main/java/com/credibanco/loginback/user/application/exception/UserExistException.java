package com.credibanco.loginback.user.application.exception;

public class UserExistException extends Exception{
    public UserExistException(String message) {
        super(message);
    }
}
