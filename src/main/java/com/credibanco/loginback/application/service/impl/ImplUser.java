package com.credibanco.loginback.application.service.impl;

import com.credibanco.loginback.application.dto.request.RequestUserDto;
import com.credibanco.loginback.application.dto.response.ResponseUserDto;
import com.credibanco.loginback.domain.model.User;
import com.credibanco.loginback.domain.repository.IRepositoryUser;
import com.credibanco.loginback.application.service.IServiceUser;
import com.credibanco.loginback.application.mapper.UserMapper;
//import com.credibanco.loginback.infrastructure.security.JwtUtils;
import com.credibanco.loginback.shared.exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImplUser implements IServiceUser {
	Logger logger = LoggerFactory.getLogger(ImplUser.class);
    @Autowired
	IRepositoryUser iRepositoryUser;
	/*@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	UserDetails userDetails;
*/
    @Override
    public List<ResponseUserDto> getAllUsers(String token) {
    	try {
			/*if (!jwtUtils.validateToken(token, userDetails)) {
				throw new UnauthorizedException("Token inválido o expirado");
			}

			 */
    		List<User> userList = iRepositoryUser.findAll();
            return userList.stream()
                    .map(UserMapper::convertUserToResponseDTO)
                    .collect(Collectors.toList());
    	}catch(Exception e) {
    		logger.error("Impl | Error.", e);
    	}
		return null;
    }

    @Override
    public ResponseUserDto getUserById(String token, long id) {
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

		try {
			logger.info("Impl | verifica si existe la identificacion");
			User user = this.iRepositoryUser.findByEmail(requestUserDto.getEmail());
			if (user != null) {
				logger.info("Impl | User exist.");
				return null;
			}else {
				User userMapper = UserMapper.convertRequestToUser(requestUserDto);
				//userMapper.setPassword(passwordEncoder.encode(requestUserDto.getPassword()));
				iRepositoryUser.saveAndFlush(userMapper);
				logger.info("Impl | Save&Flush");
				return UserMapper.convertUserToResponseDTO(userMapper);
			}

		}catch (Exception e) {
			logger.error("Impl | Error creating new user.", e);
			return null;
		}
    }

    @Override
    public ResponseUserDto updateUser(String token, long id, RequestUserDto requestUserDto) {
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
    public void deleteUser(String token, long id) {
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
