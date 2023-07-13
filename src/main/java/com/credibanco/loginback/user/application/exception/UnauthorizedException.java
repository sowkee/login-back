package com.credibanco.loginback.user.application.exception;

public class UnauthorizedException extends Exception{
    public UnauthorizedException(String message) {
        super(message);
    }
}
