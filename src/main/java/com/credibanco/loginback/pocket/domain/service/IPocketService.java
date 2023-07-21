package com.credibanco.loginback.pocket.domain.service;

import com.credibanco.loginback.pocket.infrastructure.entrypoint.dto.request.PocketRequestDto;
import com.credibanco.loginback.pocket.infrastructure.entrypoint.dto.response.PocketResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPocketService {

    List<PocketResponseDto> getPocketOfUser (long userId);
    PocketResponseDto newPocket (PocketRequestDto pocketRequestDto);
    PocketResponseDto updatePocket (long id, PocketRequestDto pocketRequestDto);
    boolean deleteOnePocket (long id, PocketRequestDto pocketRequestDto);

}
