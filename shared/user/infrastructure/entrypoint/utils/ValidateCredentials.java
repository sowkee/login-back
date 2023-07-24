package com.credibanco.loginback.shared.user.infrastructure.entrypoint.utils;


import com.credibanco.loginback.shared.user.application.exception.CredentialNullException;

public class ValidateCredentials {
    public static void credentialValidator(String credential, String message) throws CredentialNullException {
        if (credential == null) {
            throw new CredentialNullException(message);
        }
    }

}
