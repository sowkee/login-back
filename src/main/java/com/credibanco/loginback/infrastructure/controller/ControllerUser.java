package com.credibanco.loginback.infrastructure.controller;

import com.credibanco.loginback.application.dto.request.RequestUserDto;

import com.credibanco.loginback.application.dto.response.ResponseUserDto;
import com.credibanco.loginback.domain.model.User;
import com.credibanco.loginback.application.service.IServiceUser;

import com.credibanco.loginback.shared.exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("users")
@Validated
@ControllerAdvice
public class ControllerUser {


	Logger logger= LoggerFactory.getLogger(ControllerUser.class);
    @Autowired
    IServiceUser iServiceUser;
    @Autowired
    User user;

    @ExceptionHandler(value = Exception.class)

    @GetMapping ("get/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllUser(/*@RequestHeader(HttpHeaders.AUTHORIZATION) String token*/){
        Map<String, Object> res = new HashMap<>();
        String token = "";
        try {
        	List<ResponseUserDto> responseUserDto = iServiceUser.getAllUsers(token);
          if (responseUserDto != null) {
            res.put("status", HttpStatus.OK);
            res.put("data",responseUserDto);
            return new ResponseEntity<>(res,HttpStatus.OK);
         }
        }catch(Exception e) {
        	logger.error("CO | no fue posible encontrar los usuarios registrados----", e);
        }
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @GetMapping ("get/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUserById(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable long id){
        Map<String, Object> res = new HashMap<>();
        ResponseUserDto responseUserDto = iServiceUser.getUserById(token, id);
        try {
            if(responseUserDto != null) {
                res.put("status", HttpStatus.OK);
                res.put("data",responseUserDto);
                return new ResponseEntity<>(res,HttpStatus.OK);
            }
        }catch(Exception e) {
        	logger.error("---no fue posible buscar el usuario----", e);
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }  
        return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
    }

    @PostMapping ("register")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> registerUser(@Valid @RequestBody RequestUserDto requestUserDto) throws Exception {
        Map<String, Object> res = new HashMap<>();
        ResponseUserDto responseUserDto = this.iServiceUser.createUser(requestUserDto);

         if (responseUserDto != null) {
        	 res.put("status", HttpStatus.OK);
             res.put("data",responseUserDto);
             return new ResponseEntity<>(res,HttpStatus.OK);
        }
        res.put("status", HttpStatus.CONFLICT);
        res.put("message","User exist.");
        return new ResponseEntity<>(res,HttpStatus.CONFLICT);
    }

    @PutMapping ("update/{id}")
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @PathVariable long id, @RequestBody RequestUserDto requestUserDto){
    	try {
    		if (user.getId()!= id){
	    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario no encontrado");
	    	} else {
                ResponseUserDto responseUserDto = iServiceUser.updateUser(token, id, requestUserDto);
                if(responseUserDto != null) {
                    return ResponseEntity.status(HttpStatus.OK).build();
                }
            }
        } catch(Exception e) {
            logger.error("--no se pudo actualizar el usuario--",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR.");
        }
		return null;
    }
    
    @DeleteMapping ("delete/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteUser (@RequestHeader(HttpHeaders.AUTHORIZATION) String token, long id){
    	try {
            iServiceUser.deleteUser(token, id);
    	    return ResponseEntity.status(HttpStatus.OK).build();
    		}catch(Exception e) {
    			logger.error("---no fue posible eliminar el usuario --", e);
    		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
