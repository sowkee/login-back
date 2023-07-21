package com.credibanco.loginback.transaction.infrastructure.entrypoint.repository;

import com.credibanco.loginback.transaction.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
}
