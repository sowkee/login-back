package com.credibanco.loginback.infrastructure.controller;
/*
import com.credibanco.loginback.application.dto.request.JwtRequest;
import com.credibanco.loginback.application.dto.response.JwtResponse;
import com.credibanco.loginback.application.service.impl.UserDetailsServiceImpl;
import com.credibanco.loginback.infrastructure.security.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;



    Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
/*
    @PostMapping("/auth")
    public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getEmail());
            if (passwordEncoder.matches(jwtRequest.getPassword(), userDetails.getPassword())) {
                String token = jwtUtils.generateToken(userDetails);
                logger.debug("AuthController | Token generado: " + token);
                return ResponseEntity.ok(new JwtResponse(token));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/actual-usuario")
    public User obtenerUsuarioActual(Principal principal){
        return (User) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}

 */






