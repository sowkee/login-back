package com.credibanco.loginback.user.application.exception;

import lombok.Data;

@Data
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
