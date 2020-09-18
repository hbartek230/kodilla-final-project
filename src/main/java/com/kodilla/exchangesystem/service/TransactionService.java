package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.Transaction;
import com.kodilla.exchangesystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository repository;

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
}
