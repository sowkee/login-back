package com.credibanco.loginback.shared.user.domain.service;

import com.credibanco.loginback.shared.user.application.exception.*;
import com.credibanco.loginback.shared.user.infrastructure.entrypoint.dto.response.ResponseUserDto;
import com.credibanco.loginback.shared.user.infrastructure.entrypoint.dto.request.RequestUserDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface IServiceUser {
    List<ResponseUserDto> getAllUsers () throws EmptyEntityException;
    ResponseUserDto getUserById (long id) throws UserNotFoundException;
    ResponseUserDto createUser (RequestUserDto requestUserDto) throws UserExistException, SQLException, InvalidPasswordException, CredentialNullException;
    ResponseUserDto updateUser (long id, RequestUserDto requestUserDto) throws UserNotFoundException;
    boolean deleteUser (long id) throws UserNotFoundException;

}
