package com.credibanco.loginback.shared.user.infrastructure.entrypoint.utils;

import com.credibanco.loginback.shared.user.application.exception.CredentialNullException;

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
