package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findByUserId(Long userId);

    Transaction findByCurrencyId(Long currencyId);

    Transaction findByUserIdAndCurrencyId(Long userId, Long currencyId);

    Transaction findByUserIdAndTransactionId(Long userId, Long transactionId);
}
