package com.credibanco.loginback.domain.repository;

import com.credibanco.loginback.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IRepositoryUser extends JpaRepository <User,Long> {
    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
}
