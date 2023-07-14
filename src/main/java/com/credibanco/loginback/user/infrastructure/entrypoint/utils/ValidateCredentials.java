package com.credibanco.loginback.user.infrastructure.entrypoint.utils;

import com.credibanco.loginback.user.application.exception.CredentialNullException;
import com.credibanco.loginback.user.application.exception.InvalidPasswordException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.sql.SQLException;
import java.util.Objects;

public class ValidateCredentials {


    private final static String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    public static void credentialValidator(String credential, String message) throws CredentialNullException {
        if (credential == null) {
            throw new CredentialNullException(message);
        }
    }

//    public static void validatePassword(String password, String message)  {
//
//        throw new MethodArgumentNotValidException(message, );
//
//    }
}
