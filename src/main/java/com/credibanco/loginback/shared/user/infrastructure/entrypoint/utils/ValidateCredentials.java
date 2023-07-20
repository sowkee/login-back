package com.credibanco.loginback.shared.user.infrastructure.entrypoint.utils;

<<<<<<< HEAD:src/main/java/com/credibanco/loginback/user/infrastructure/entrypoint/utils/ValidateCredentials.java
import com.credibanco.loginback.user.application.exception.CredentialNullException;
=======
import com.credibanco.loginback.shared.user.application.exception.CredentialNullException;
>>>>>>> 5468f53ac6d4d2a45395015ce3066bdd3df3fa1b:src/main/java/com/credibanco/loginback/shared/user/infrastructure/entrypoint/utils/ValidateCredentials.java

public class ValidateCredentials {
    public static void credentialValidator(String credential, String message) throws CredentialNullException {
        if (credential == null) {
            throw new CredentialNullException(message);
        }
    }

}
