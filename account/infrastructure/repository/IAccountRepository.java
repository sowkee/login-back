package com.credibanco.loginback.account.infrastructure.repository;

import com.credibanco.loginback.account.domain.entity.Account;
import com.credibanco.loginback.shared.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository <Account, Long> {

    User findByPhoneNumber (String phoneNumber);

}
