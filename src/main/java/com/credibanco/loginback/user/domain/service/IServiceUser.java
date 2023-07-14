package com.credibanco.loginback.user.domain.service;

import com.credibanco.loginback.user.application.exception.*;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.request.RequestPasswordDto;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.request.RequestUserDto;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.response.ResponsePasswordDto;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.response.ResponseUserDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface IServiceUser {
    List<ResponseUserDto> getAllUsers () throws EmptyEntityException;
    ResponseUserDto getUserById (long id) throws UserNotFoundException;
    ResponseUserDto createUser (RequestUserDto requestUserDto) throws UserExistException, SQLException, InvalidPasswordException, CredentialNullException;
    ResponseUserDto updateUser (long id, RequestUserDto requestUserDto) throws UserNotFoundException;
    ResponsePasswordDto changePassword(RequestPasswordDto requestPasswordDto);
    ResponsePasswordDto forgotPassword(RequestPasswordDto requestPasswordDto);
    boolean deleteUser (long id) throws UserNotFoundException;

}
