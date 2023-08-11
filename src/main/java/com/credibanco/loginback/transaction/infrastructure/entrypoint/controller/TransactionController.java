package com.credibanco.loginback.transaction.infrastructure.entrypoint.controller;

import com.credibanco.loginback.transaction.domain.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    ITransactionService iTransactionService;


}
