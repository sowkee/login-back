package com.credibanco.loginback.account.application.service;

import com.credibanco.loginback.account.domain.service.IServiceAccount;
import com.credibanco.loginback.account.infrastructure.dto.request.RequestAccountDto;
import com.credibanco.loginback.account.infrastructure.dto.response.ResponseAccountDto;

public class AccountImpl implements IServiceAccount {

    @Override
    public ResponseAccountDto createAccount(RequestAccountDto requestAccountDto) {

        return null;
    }

    @Override
    public ResponseAccountDto getAllAccount() {
        return null;
    }

    @Override
    public ResponseAccountDto getPhoneNumberAccount(String phoneNumber) {
        return null;
    }

    @Override
    public String deleteAccount(String phoneNumber) {
        return null;
    }
}
