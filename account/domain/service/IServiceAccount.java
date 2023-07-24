package com.credibanco.loginback.account.domain.service;

import com.credibanco.loginback.account.infrastructure.dto.request.RequestAccountDto;
import com.credibanco.loginback.account.infrastructure.dto.response.ResponseAccountDto;

public interface IServiceAccount {

    ResponseAccountDto createAccount (RequestAccountDto requestAccountDto);
    ResponseAccountDto getAllAccount ();

    ResponseAccountDto getPhoneNumberAccount (String phoneNumber);

    String deleteAccount (String phoneNumber);

}
