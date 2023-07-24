package com.credibanco.loginback.shared.exception;

import lombok.Builder;
import lombok.Data;

@Data

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message) {
        super(message);
    }

}
