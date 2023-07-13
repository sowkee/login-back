package com.credibanco.loginback.otp.app.service;


import com.credibanco.loginback.otp.domain.service.IServiceOtp;
import com.credibanco.loginback.otp.domain.entity.Otp;
import com.credibanco.loginback.otp.infrastructure.respository.IRepositoryOtp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImplOtp implements IServiceOtp {

    @Autowired
    IRepositoryOtp iRepositoryOtp;
    Logger logger = LoggerFactory.getLogger(ImplOtp.class);

    @Override
    public void setOtpAndStore(String code) {

        Otp otp = new Otp();
        otp.setDateCreate(new Date());
        otp.setOperation("enviado");
        otp.setComunication("sms");
        logger.info("ImplOtp | Se registro otp.");

    }

    public String generateOtp() {
        List<Integer> numbers = new ArrayList<>();
        int randomNumber;

        for (int i = 1; i <= 6; i++){
            randomNumber = (int) (Math.random()*10);
            numbers.add(randomNumber);
        }
        return concatNumber(numbers);
    }

    public String concatNumber(List<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            result.append(number);
        }
        return result.toString();
    }

}
