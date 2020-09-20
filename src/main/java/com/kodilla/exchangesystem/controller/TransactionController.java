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

    @GetMapping(params = "userId")
    public TransactionDto getUserTransactions(@RequestParam Long userId) {
        return new TransactionDto();
    }

    @GetMapping(params = "currencySoldId")
    public TransactionDto getCurrencySoldTransactions(@RequestParam Long currencySoldId) {
        return new TransactionDto();
    }

    @GetMapping(params = {"userId, currencySoldId"})
    public TransactionDto getUserTransactionsByCurrencySold(@RequestParam Long userId,
                                                            @RequestParam Long currencySoldId) {
        return new TransactionDto();
    }

    @GetMapping(params = "currencyBoughtId")
    public TransactionDto getCurrencyBoughtTransactions(@RequestParam Long currencyBoughtId) {
        return new TransactionDto();
    }

    @GetMapping(params = {"userId, currencyBoughtId"})
    public TransactionDto getUserTransactionsByCurrencyBought(@RequestParam Long userId,
                                                              @RequestParam Long currencyBoughtId) {
        return new TransactionDto();
    }

    @GetMapping(params = {"userId, transactionId"})
    public TransactionDto getSingleUserTransaction(@RequestParam Long userId,
                                                   @RequestParam Long transactionId) {
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
