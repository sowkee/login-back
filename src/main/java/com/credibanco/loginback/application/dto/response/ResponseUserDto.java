package com.credibanco.loginback.application.dto.response;

import com.credibanco.loginback.domain.model.Otp;
import com.credibanco.loginback.domain.model.Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import com.credibanco.loginback.application.dto.request.RequestUserDto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;


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
