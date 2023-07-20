package com.credibanco.loginback.pocket.application.service;

import com.credibanco.loginback.pocket.domain.entity.Pocket;
import com.credibanco.loginback.pocket.domain.service.IPocketService;
import com.credibanco.loginback.pocket.infrastructure.entrypoint.dto.request.PocketRequestDto;
import com.credibanco.loginback.pocket.infrastructure.entrypoint.dto.response.PocketResponseDto;
import com.credibanco.loginback.pocket.infrastructure.entrypoint.mapper.PocketMapper;
import com.credibanco.loginback.pocket.infrastructure.entrypoint.repository.IPocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PocketImpl implements IPocketService {

    @Autowired
    IPocketRepository iPocketRepository;


    @Override
    public List<PocketResponseDto> getPocketOfUser(
            long userId) {

        List<Pocket> pockets = this.iPocketRepository.findByUserId(userId);

        return pockets.stream()
                .map(PocketMapper::convertPocketToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PocketResponseDto newPocket(PocketRequestDto pocketRequestDto) {

        Pocket pocket = PocketMapper.convertRequestToPocket(pocketRequestDto);
        iPocketRepository.save(pocket);

        return PocketMapper.convertPocketToResponse(pocket);
    }

    @Override
    public PocketResponseDto updatePocket(
            long id,
            PocketRequestDto pocketRequestDto) {

        Pocket pocket = this.iPocketRepository.findById(id);

        if (pocket == null) {

        }

        pocket = PocketMapper.convertRequestToPocket(pocketRequestDto);
        iPocketRepository.save(pocket);

        return PocketMapper.convertPocketToResponse(pocket);
    }

    @Override
    public boolean deleteOnePocket(long id, PocketRequestDto pocketRequestDto) {
        Pocket pocket = this.iPocketRepository.findById(id);

        if (pocket == null) {

        }

        this.iPocketRepository.delete(pocket);
        return true;
    }
}
