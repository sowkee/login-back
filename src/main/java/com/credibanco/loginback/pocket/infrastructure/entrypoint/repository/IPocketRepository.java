package com.credibanco.loginback.pocket.infrastructure.entrypoint.repository;

import com.credibanco.loginback.pocket.domain.entity.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPocketRepository extends JpaRepository<Pocket, Long> {

    List<Pocket> findByUserId(long userId);
    Pocket findById(long id);
}
