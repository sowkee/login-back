package com.credibanco.loginback.transaction.infrastructure.entrypoint.mapper;

import com.credibanco.loginback.transaction.domain.entity.Transaction;
import com.credibanco.loginback.transaction.infrastructure.entrypoint.dto.request.TransactionRequestDto;
import com.credibanco.loginback.transaction.infrastructure.entrypoint.dto.response.TransactionResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static TransactionResponseDto convertTransactionToResponse(Transaction transaction){
        return null;
    }

    public static Transaction convertRequestToTransaction(TransactionRequestDto transactionRequestDto){
        return null;
    }

}
