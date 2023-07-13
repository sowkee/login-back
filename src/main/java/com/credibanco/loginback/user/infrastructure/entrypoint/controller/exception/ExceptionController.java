package com.credibanco.loginback.user.infrastructure.entrypoint.controller.exception;

import com.credibanco.loginback.user.application.exception.EmptyEntityException;
import com.credibanco.loginback.user.application.exception.UnauthorizedException;
import com.credibanco.loginback.user.application.exception.UserExistException;
import com.credibanco.loginback.user.application.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> handlerUserNotFoundException (UserNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmptyEntityException.class)
    public ResponseEntity<String> handlerEmptyEntityException (EmptyEntityException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(value = UserExistException.class)
    public  ResponseEntity<String> handlerUserExistException (UserExistException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

}
