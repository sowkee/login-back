package com.credibanco.loginback.application.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import com.credibanco.loginback.application.dto.request.RequestUserDto;


@Component
public class ResponseUserDto extends RequestUserDto{

    @JsonIgnore
    private String password;
}
