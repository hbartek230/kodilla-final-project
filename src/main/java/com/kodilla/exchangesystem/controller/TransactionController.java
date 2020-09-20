package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.TransactionDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @GetMapping
    public List<TransactionDto> getTransactions() {
        return new ArrayList<>();
    }

    @GetMapping
    public TransactionDto getUserTransactions(@RequestParam Long userId) {
        return new TransactionDto();
    }

    @GetMapping
    public TransactionDto getCurrencyTransactions(@RequestParam Long currencyId) {
        return new TransactionDto();
    }

    @GetMapping
    public TransactionDto getUserTransactionsByCurrency(@RequestParam Long userId, @RequestParam Long currencyId) {
        return new TransactionDto();
    }

    @GetMapping
    public TransactionDto getSingleUserTransaction(@RequestParam Long userId, @RequestParam Long transactionId) {
        return new TransactionDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public TransactionDto createTransaction(@RequestBody TransactionDto transactionDto) {
        return new TransactionDto();
    }

    @PutMapping
    public TransactionDto updateTransaction(@RequestBody TransactionDto transactionDto) {
        return new TransactionDto();
    }

    @DeleteMapping
    public void deleteTransaction(@RequestParam Long transactionId) {

    }
}
