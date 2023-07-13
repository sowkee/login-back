package com.credibanco.loginback.user.application.service;

import com.credibanco.loginback.user.infrastructure.entrypoint.dto.request.RequestPasswordDto;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.response.ResponsePasswordDto;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.response.ResponseUserDto;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.request.RequestUserDto;
import com.credibanco.loginback.user.domain.entity.User;
import com.credibanco.loginback.user.infrastructure.entrypoint.repository.IRepositoryUser;
import com.credibanco.loginback.user.domain.service.IServiceUser;
import com.credibanco.loginback.user.infrastructure.entrypoint.mapper.UserMapper;
import com.credibanco.loginback.user.application.exception.EmptyEntityException;
import com.credibanco.loginback.user.application.exception.UserExistException;
import com.credibanco.loginback.user.application.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

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
		if (userList == null) {
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
			throws UserExistException {
			User user = this.iRepositoryUser.findByEmail(requestUserDto.getEmail());
			if (user != null) {
				logger.info("Impl | User exist.");
				throw new UserExistException("User exist.");
			}
			UserMapper.convertRequestToUser(requestUserDto);
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
	public ResponsePasswordDto changePassword(RequestPasswordDto requestPasswordDto) {
		
		return null;
	}

	@Override
	public ResponsePasswordDto forgotPassword(RequestPasswordDto requestPasswordDto) {
		return null;
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
