package com.credibanco.loginback.domain.repository;

import com.credibanco.loginback.domain.model.Otp;
import com.credibanco.loginback.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryOtp extends JpaRepository<Otp, Long> {
    Otp findByOtp(String otp);

    Otp findByUser(User user);
}
