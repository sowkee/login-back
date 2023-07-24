package com.credibanco.loginback.otp.domain.service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceOtp {
    String generateOtp();
    String concatNumber(List<Integer> numbers);
    void setOtpAndStore(String code);

}
