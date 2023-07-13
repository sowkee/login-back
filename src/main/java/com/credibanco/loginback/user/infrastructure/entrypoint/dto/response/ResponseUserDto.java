package com.credibanco.loginback.user.infrastructure.entrypoint.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import com.credibanco.loginback.user.infrastructure.entrypoint.dto.request.RequestUserDto;


@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseUserDto extends RequestUserDto{

    @JsonIgnore
    private String password;
//    @JsonProperty("otp")
//    @JsonIgnore
//    private Otp otp;
//    @JsonProperty("rol")
//    @JsonIgnore
//    private List<Rol> rol;
}
