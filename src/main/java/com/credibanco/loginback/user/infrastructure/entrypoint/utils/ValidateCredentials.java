package com.credibanco.loginback.user.infrastructure.entrypoint.utils;

import com.credibanco.loginback.user.application.exception.CredentialNullException;

public class ValidateCredentials {
    public static void credentialValidator(String credential, String message) throws CredentialNullException {
        if (credential == null) {
            throw new CredentialNullException(message);
        }
    }

}
