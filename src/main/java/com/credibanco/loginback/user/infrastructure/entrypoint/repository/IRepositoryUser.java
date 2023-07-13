package com.credibanco.loginback.user.infrastructure.entrypoint.repository;

import com.credibanco.loginback.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IRepositoryUser extends JpaRepository <User,Long> {
    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
    User findUserById(long id);
}
