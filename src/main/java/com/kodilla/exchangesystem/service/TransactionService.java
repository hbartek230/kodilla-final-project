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

    public Transaction getTransactionByCurrency(Long currencyId) {
        return repository.findByCurrencyId(currencyId);
    }

    public Transaction getUserTransactionByCurrency(Long userId, Long currencyId) {
        return repository.findByUserIdAndCurrencyId(userId, currencyId);
    }

    public Transaction getSingleUserTransaction(Long userId, Long transactionId) {
        return repository.findByUserIdAndTransactionId(userId, transactionId);
    }

    public void addTransaction(Transaction transaction) {
        repository.save(transaction);
    }

    public void deleteTransaction(Long transactionId) {
        repository.deleteById(transactionId);
    }
}
