package com.credibanco.loginback.otp.infrastructure.respository;

import com.credibanco.loginback.otp.domain.entity.Otp;
import com.credibanco.loginback.shared.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryOtp extends JpaRepository<Otp, Long> {
    Otp findByOtp(String otp);

    Otp findByUser(User user);
}
