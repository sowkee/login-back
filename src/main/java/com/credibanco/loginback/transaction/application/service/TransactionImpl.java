package com.credibanco.loginback.transaction.application.service;

import com.credibanco.loginback.transaction.domain.service.ITransactionService;
import com.credibanco.loginback.transaction.infrastructure.entrypoint.dto.request.TransactionRequestDto;
import com.credibanco.loginback.transaction.infrastructure.entrypoint.dto.response.TransactionResponseDto;
import com.credibanco.loginback.transaction.infrastructure.entrypoint.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionImpl implements ITransactionService {

    @Autowired
    ITransactionRepository iTransactionRepository;

    @Override
    public TransactionResponseDto sendTransaction(TransactionRequestDto transactionRequestDto) {
        return null;
    }

    @Override
    public TransactionResponseDto withdrawTransaction(TransactionRequestDto transactionRequestDto) {
        return null;
    }
}
