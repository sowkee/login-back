package com.credibanco.loginback.application.mapper;


import com.credibanco.loginback.application.dto.request.RequestUserDto;
import com.credibanco.loginback.application.dto.response.ResponseUserDto;
import com.credibanco.loginback.domain.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private static ObjectMapper objectMapper;
    public static ResponseUserDto convertUserToResponseDTO (User user){
        return objectMapper.convertValue(user, ResponseUserDto.class);
    }

    public static User convertRequestToUser(RequestUserDto requestUserDto) {
        return objectMapper.convertValue(requestUserDto, User.class);
    }
}
