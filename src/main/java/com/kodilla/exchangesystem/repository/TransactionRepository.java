package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findByUserId(Long userId);

    Transaction findByCurrencySoldId(Long currencySoldId);

    Transaction findByUserIdAndCurrencySoldId(Long userId, Long currencySoldId);

    Transaction findByCurrencyBoughtId(Long currencyBoughtId);

    Transaction findByUserIdAndCurrencyBoughtId(Long userId, Long currencyBoughtId);

    Transaction findByIdAndUserId(Long transactionId, Long userId);
}
