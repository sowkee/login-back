package com.credibanco.loginback.application.service;

import com.credibanco.loginback.application.dto.request.RequestUserDto;
import com.credibanco.loginback.application.dto.response.ResponseUserDto;
import com.credibanco.loginback.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceUser {
    List<ResponseUserDto> getAllUsers (String token);
    ResponseUserDto getUserById (String token, long id);
    ResponseUserDto createUser (RequestUserDto requestUserDto) throws Exception;
    ResponseUserDto updateUser (String token, long id, RequestUserDto requestUserDto);
    void deleteUser (String token, long id);

}
