package com.credibanco.loginback.application.service.impl;

import com.credibanco.loginback.application.dto.request.RequestUserDto;
import com.credibanco.loginback.application.dto.response.ResponseUserDto;
import com.credibanco.loginback.domain.model.User;
import com.credibanco.loginback.domain.repository.IRepositoryUser;
import com.credibanco.loginback.application.service.IServiceUser;
import com.credibanco.loginback.application.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImplUser implements IServiceUser {
	Logger logger = LoggerFactory.getLogger(ImplUser.class);
	
    @Autowired
	IRepositoryUser iRepositoryUser;

    @Autowired
    ObjectMapper objectMapper;

	@Autowired
	PasswordEncoder passwordEncoder;

    
    @Override
    public List<ResponseUserDto> getAllUsers() {
    	try {
    		List<User> userList = iRepositoryUser.findAll();
            return userList.stream()
                    .map(user -> UserMapper.convertUserToResponseDTO(user))
                    .collect(Collectors.toList());
    	}catch(Exception e) {
    		logger.error("Impl | Error.", e);
    	}
		return null;
    }

    @Override
    public ResponseUserDto getUserById(long id) {
    	try {
            Optional <User> optionalUser = iRepositoryUser.findById(id);
            if (optionalUser.isPresent()){
                User user = optionalUser.get();
                return UserMapper.convertUserToResponseDTO(user);
            }
    	}catch(Exception e) {
    		logger.error("Impl | Error", e);
    	}
        return null;
    }

    @Override
    public ResponseUserDto createUser(RequestUserDto requestUserDto)  {

		User user = this.iRepositoryUser.findByIdentification(requestUserDto.getIdentification());
		if (user != null) {
			logger.info("User exist.");
			return null;
		}else {
			user = UserMapper.convertRequestToUser(requestUserDto);
			user.setPassword(passwordEncoder.encode(requestUserDto.getPassword()));
			iRepositoryUser.saveAndFlush(user);
			return UserMapper.convertUserToResponseDTO(user);
		}

    }

    @Override
    public ResponseUserDto updateUser(long id, RequestUserDto requestUserDto) {
    	try {
            User user = iRepositoryUser.findById(id).orElseThrow(NoSuchElementException::new);
            BeanUtils.copyProperties(requestUserDto, user);
            return UserMapper.convertUserToResponseDTO(user);
    	}catch(Exception e) {
    		logger.error("Impl | Error", e);
    	}
		return null;
    }

    @Override
    public void deleteUser(long id) {
    	try {
    		 Optional<User> optionalUser = iRepositoryUser.findById(id);
    	        if (optionalUser.isPresent()){
    	            User user = optionalUser.get();
    	            iRepositoryUser.delete(user);
    	        }
    	}catch(Exception e) {
    		logger.error("Impl | Error", e);
    	}

    }



}
