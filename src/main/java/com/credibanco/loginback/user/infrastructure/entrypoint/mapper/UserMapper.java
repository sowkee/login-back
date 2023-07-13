package com.credibanco.loginback.user.infrastructure.entrypoint.mapper;


import com.credibanco.loginback.user.infrastructure.entrypoint.dto.request.RequestUserDto;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.response.ResponseUserDto;
import com.credibanco.loginback.user.domain.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static ResponseUserDto convertUserToResponseDTO (User user){
        return objectMapper.convertValue(user, ResponseUserDto.class);
    }

    public static User convertRequestToUser(RequestUserDto requestUserDto) {
        return objectMapper.convertValue(requestUserDto, User.class);
    }
}
