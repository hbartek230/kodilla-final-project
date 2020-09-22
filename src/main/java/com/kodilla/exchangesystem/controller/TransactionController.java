package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.TransactionDto;
import com.kodilla.exchangesystem.exception.UserNotFoundException;
import com.kodilla.exchangesystem.mapper.TransactionMapper;
import com.kodilla.exchangesystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    @Autowired
    public TransactionController(TransactionRepository repository, TransactionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping
    public List<TransactionDto> getTransactions() {
        return mapper.mapToTransactionDtoList(repository.findAll());
    }

    @GetMapping(params = "userId")
    public TransactionDto getUserTransactions(@RequestParam Long userId) {
        return mapper.mapToTransactionDto(repository.findByUserId(userId));
    }

    @GetMapping(params = "currencySoldId")
    public TransactionDto getCurrencySoldTransactions(@RequestParam Long currencySoldId) {
        return mapper.mapToTransactionDto(repository.findByCurrencySoldId(currencySoldId));
    }

    @GetMapping(params = {"userId, currencySoldId"})
    public TransactionDto getUserTransactionsByCurrencySold(@RequestParam Long userId,
                                                            @RequestParam Long currencySoldId) {
        return mapper.mapToTransactionDto(repository.findByUserIdAndCurrencySoldId(userId, currencySoldId));
    }

    @GetMapping(params = "currencyBoughtId")
    public TransactionDto getCurrencyBoughtTransactions(@RequestParam Long currencyBoughtId) {
        return mapper.mapToTransactionDto(repository.findByCurrencyBoughtId(currencyBoughtId));
    }

    @GetMapping(params = {"userId, currencyBoughtId"})
    public TransactionDto getUserTransactionsByCurrencyBought(@RequestParam Long userId,
                                                              @RequestParam Long currencyBoughtId) {
        return mapper.mapToTransactionDto(repository.findByUserIdAndCurrencyBoughtId(userId, currencyBoughtId));
    }

    @GetMapping(params = {"transactionId, userId"})
    public TransactionDto getSingleUserTransaction(@RequestParam Long transactionId,
                                                   @RequestParam Long userId) {
        return mapper.mapToTransactionDto(repository.findByIdAndUserId(transactionId, userId));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public TransactionDto createTransaction(@RequestBody TransactionDto transactionDto) throws UserNotFoundException {
        return mapper.mapToTransactionDto(repository.save(mapper.mapToTransaction(transactionDto)));
    }

    @PutMapping
    public TransactionDto updateTransaction(@RequestBody TransactionDto transactionDto) throws UserNotFoundException {
        return mapper.mapToTransactionDto(repository.save(mapper.mapToTransaction(transactionDto)));
    }

    @DeleteMapping
    public void deleteTransaction(@RequestParam Long transactionId) {
        repository.deleteById(transactionId);
    }
}
