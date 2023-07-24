package com.credibanco.loginback.transaction.domain.service;

import com.credibanco.loginback.transaction.infrastructure.entrypoint.dto.request.TransactionRequestDto;
import com.credibanco.loginback.transaction.infrastructure.entrypoint.dto.response.TransactionResponseDto;
import org.springframework.stereotype.Service;

import java.lang.ref.Reference;
import java.util.List;

@Service
public interface ITransactionService {


    List <TransactionResponseDto> getAllTransactions ();
    TransactionResponseDto getByReference (String reference);
    TransactionResponseDto sendTransaction (TransactionRequestDto transactionRequestDto);
    TransactionResponseDto withdrawTransaction (TransactionRequestDto transactionRequestDto);

}