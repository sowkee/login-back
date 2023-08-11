package com.credibanco.loginback.shared.user.infrastructure.entrypoint.dto.request;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Component
public class RequestPasswordDto {

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "La contraseña no es valida, ej.(Ejpl1234*)")
    @NotNull
    private String latestPassword;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "La contraseña no es valida, ej.(Ejpl1234*)")
    @NotNull
    private String newPassword;
}
