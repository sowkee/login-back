package com.credibanco.loginback.pocket.infrastructure.entrypoint.controller;

import com.credibanco.loginback.pocket.domain.service.IPocketService;
import com.credibanco.loginback.pocket.infrastructure.entrypoint.dto.response.PocketResponseDto;
import com.credibanco.loginback.user.domain.entity.User;
import com.credibanco.loginback.user.infrastructure.entrypoint.dto.response.ResponseUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pockets")
public class PocketController {

    @Autowired
    IPocketService iPocketService;

    @GetMapping("{id}")
    public ResponseEntity<PocketResponseDto> getPocketsOfUser(@PathVariable long id) {
        List<PocketResponseDto> pocketResponseDto = iPocketService.getPocketOfUser(id);
        return null;
    }





}
