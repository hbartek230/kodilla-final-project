package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.Transaction;
import com.kodilla.exchangesystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    @Autowired
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getTransactions() {
        return repository.findAll();
    }

    public Transaction getTransactionByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public Transaction getTransactionByCurrencySold(Long currencySoldId) {
        return repository.findByCurrencySoldId(currencySoldId);
    }

    public Transaction getUserTransactionByCurrencySold(Long userId, Long currencySoldId) {
        return repository.findByUserIdAndCurrencySoldId(userId, currencySoldId);
    }

    public Transaction getTransactionByCurrencyBought(Long currencyBoughtId) {
        return repository.findByCurrencyBoughtId(currencyBoughtId);
    }

    public Transaction getUserTransactionByCurrencyBought(Long userId, Long currencyBoughtId) {
        return repository.findByUserIdAndCurrencyBoughtId(userId, currencyBoughtId);
    }

    public Transaction getSingleUserTransaction(Long transactionId, Long userId) {
        return repository.findByIdAndUserId(transactionId, userId);
    }

    public Transaction addTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public void deleteTransaction(Long transactionId) {
        repository.deleteById(transactionId);
    }
}
