package com.credibanco.loginback.shared.user.infrastructure.entrypoint.controller;

import com.credibanco.loginback.shared.user.infrastructure.entrypoint.dto.response.ResponseUserDto;
import com.credibanco.loginback.shared.user.application.exception.EmptyEntityException;
import com.credibanco.loginback.shared.user.application.exception.UserExistException;
import com.credibanco.loginback.shared.user.infrastructure.entrypoint.dto.request.RequestUserDto;
import com.credibanco.loginback.shared.user.domain.service.IServiceUser;
import com.credibanco.loginback.shared.user.application.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("admin")
@Validated
public class ControllerUser {
	Logger logger = LoggerFactory.getLogger(ControllerUser.class);
    @Autowired
    IServiceUser iServiceUser;

    @GetMapping ("all")
    @ResponseBody
    public ResponseEntity<ResponseUserDto> getAllUser(@RequestHeader("Authorization") String token)
            throws EmptyEntityException {
        List<ResponseUserDto> responseUserDto = iServiceUser.getAllUsers();
        if (responseUserDto == null) {
            throw new EmptyEntityException("Entity is empty");
        }
        return new ResponseEntity(responseUserDto, HttpStatus.OK);
    }

    @GetMapping ("{id}")
    @ResponseBody
    public ResponseEntity<ResponseUserDto> getUserById(
            @PathVariable long id) throws UserNotFoundException {
        ResponseUserDto responseUserDto = iServiceUser.getUserById(id);
        if(responseUserDto == null) {
            throw new UserNotFoundException("User not found.");
        }
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }

    @PostMapping ("/")
    @ResponseBody
    public ResponseEntity<ResponseUserDto> registerUser(
            @Valid
            @RequestBody RequestUserDto requestUserDto) throws Exception {
        ResponseUserDto responseUserDto = this.iServiceUser.createUser(requestUserDto);
         if (responseUserDto == null) {
             throw new UserExistException("User exist.");
        }
        return new ResponseEntity(responseUserDto,HttpStatus.OK);
    }

    @PutMapping ("{id}")
    @ResponseBody
    public ResponseEntity<ResponseUserDto> updateUser(
            @PathVariable long id,
            @RequestBody RequestUserDto requestUserDto) throws UserNotFoundException {
        ResponseUserDto response = iServiceUser.updateUser(id, requestUserDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    
    @DeleteMapping ("{id}")
    @ResponseBody
    public ResponseEntity<String> deleteUser (
            @PathVariable long id) throws UserNotFoundException {
        iServiceUser.deleteUser(id);
        return new ResponseEntity("Deleted.", HttpStatus.OK);
    }
}
