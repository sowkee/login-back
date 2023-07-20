package com.credibanco.loginback.shared.user.application.service;

import com.credibanco.loginback.shared.user.application.exception.CredentialNullException;
import com.credibanco.loginback.shared.user.application.exception.EmptyEntityException;
import com.credibanco.loginback.shared.user.application.exception.UserExistException;
import com.credibanco.loginback.shared.user.application.exception.UserNotFoundException;
import com.credibanco.loginback.shared.user.domain.entity.User;
import com.credibanco.loginback.shared.user.domain.service.IServiceUser;
import com.credibanco.loginback.shared.user.infrastructure.entrypoint.dto.response.ResponseUserDto;
import com.credibanco.loginback.shared.user.infrastructure.entrypoint.mapper.UserMapper;
import com.credibanco.loginback.shared.user.infrastructure.entrypoint.repository.IRepositoryUser;
import com.credibanco.loginback.shared.user.infrastructure.entrypoint.utils.ValidateCredentials;
import com.credibanco.loginback.shared.user.infrastructure.entrypoint.dto.request.RequestUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImplUser implements IServiceUser {
	Logger logger = LoggerFactory.getLogger(ImplUser.class);
    @Autowired
	IRepositoryUser iRepositoryUser;
    @Override
    public List<ResponseUserDto> getAllUsers()
			throws EmptyEntityException {

		List<User> userList = iRepositoryUser.findAll();

		if (userList.isEmpty()) {
			logger.info("Impl | Entity is empty.");
			throw new EmptyEntityException("Entity is empty.");
		}

		return userList.stream()
				.map(UserMapper::convertUserToResponseDTO)
				.collect(Collectors.toList());
    }

    @Override
    public ResponseUserDto getUserById(long id)
			throws UserNotFoundException {

		Optional <User> optionalUser = iRepositoryUser.findById(id);

		if (!optionalUser.isPresent()) {
			logger.info("Impl | User not found.");
			throw new UserNotFoundException("User not found");
		}

		User user = optionalUser.get();
		return UserMapper.convertUserToResponseDTO(user);
    }

    @Override
    public ResponseUserDto createUser(RequestUserDto requestUserDto)
			throws UserExistException, CredentialNullException {

		ValidateCredentials.credentialValidator(requestUserDto.getName(), "Name cannot be null");
		ValidateCredentials.credentialValidator(requestUserDto.getLastname(), "Lastname cannot be null");
		ValidateCredentials.credentialValidator(requestUserDto.getPassword(), "Password cannot be null");

		Optional<User> userEmail = this.iRepositoryUser.findOneByEmail(requestUserDto.getEmail());
		Optional<User> userPhone = this.iRepositoryUser.findByPhoneNumber(requestUserDto.getPhoneNumber());

		if (userEmail.isPresent()|| userPhone.isPresent()) {
			logger.info("Impl | User exist.");
			throw new UserExistException("User exist.");
		}

		User user = UserMapper.convertRequestToUser(requestUserDto);
		iRepositoryUser.saveAndFlush(user);
		logger.info("Impl | Save&Flush");
		return UserMapper.convertUserToResponseDTO(user);
    }

    @Override
    public ResponseUserDto updateUser(long id, RequestUserDto requestUserDto)
			throws UserNotFoundException {

		User user = iRepositoryUser.findUserById(id);

		if (user == null) {
			logger.info("Impl | User not found.");
			throw new UserNotFoundException("User not found.");
		}

		user = UserMapper.convertRequestToUser(requestUserDto);
		iRepositoryUser.save(user);
		return UserMapper.convertUserToResponseDTO(user);
    }

    @Override
    public boolean deleteUser(long id)
			throws UserNotFoundException {
		Optional<User> optionalUser = iRepositoryUser.findById(id);
		if (!optionalUser.isPresent()) {
			logger.info("Impl | User not found.");
			throw new UserNotFoundException("User not found");
		}
		User user = optionalUser.get();
		iRepositoryUser.delete(user);
		return true;
    }
}
