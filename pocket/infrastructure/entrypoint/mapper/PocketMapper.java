package com.credibanco.loginback.pocket.infrastructure.entrypoint.mapper;

import com.credibanco.loginback.pocket.domain.entity.Pocket;
import com.credibanco.loginback.pocket.infrastructure.entrypoint.dto.request.PocketRequestDto;
import com.credibanco.loginback.pocket.infrastructure.entrypoint.dto.response.PocketResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class PocketMapper {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static PocketResponseDto convertPocketToResponse(Pocket pocket) {

        return objectMapper.convertValue(pocket, PocketResponseDto.class);
    }

    public static Pocket convertRequestToPocket(PocketRequestDto pocketRequestDto) {
        return objectMapper.convertValue(pocketRequestDto, Pocket.class);
    }
}
