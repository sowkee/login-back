package com.credibanco.loginback.shared.user.infrastructure.entrypoint.mapper;


import com.credibanco.loginback.shared.user.infrastructure.entrypoint.dto.request.RequestUserDto;
import com.credibanco.loginback.shared.user.infrastructure.entrypoint.dto.response.ResponseUserDto;
import com.credibanco.loginback.shared.user.domain.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static ResponseUserDto convertUserToResponseDTO (User user){
        return objectMapper.convertValue(user, ResponseUserDto.class);
    }

    public static User convertRequestToUser(RequestUserDto requestUserDto) {
        return objectMapper.convertValue(requestUserDto, User.class);
    }
}
