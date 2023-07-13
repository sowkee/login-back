package com.credibanco.loginback.user.domain.service;

import com.credibanco.loginback.user.application.exception.UserExistException;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.request.RequestPasswordDto;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.request.RequestUserDto;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.response.ResponsePasswordDto;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.response.ResponseUserDto;
import com.credibanco.loginback.user.application.exception.EmptyEntityException;
import com.credibanco.loginback.user.application.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceUser {
    List<ResponseUserDto> getAllUsers () throws EmptyEntityException;
    ResponseUserDto getUserById (long id) throws UserNotFoundException;
    ResponseUserDto createUser (RequestUserDto requestUserDto) throws UserExistException;
    ResponseUserDto updateUser (long id, RequestUserDto requestUserDto) throws UserNotFoundException;
    ResponsePasswordDto changePassword(RequestPasswordDto requestPasswordDto);
    ResponsePasswordDto forgotPassword(RequestPasswordDto requestPasswordDto);
    boolean deleteUser (long id) throws UserNotFoundException;

}
