package com.credibanco.loginback.transaction.domain.service;

import com.credibanco.loginback.transaction.infrastructure.entrypoint.dto.request.TransactionRequestDto;
import com.credibanco.loginback.transaction.infrastructure.entrypoint.dto.response.TransactionResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ITransactionService {

    TransactionResponseDto sendTransaction (TransactionRequestDto transactionRequestDto);

    TransactionResponseDto withdrawTransaction (TransactionRequestDto transactionRequestDto);



}
