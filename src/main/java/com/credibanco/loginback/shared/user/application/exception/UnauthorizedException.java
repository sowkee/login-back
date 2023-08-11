package com.credibanco.loginback.shared.user.application.exception;

public class UnauthorizedException extends Exception{
    public UnauthorizedException(String message) {
        super(message);
    }
}
