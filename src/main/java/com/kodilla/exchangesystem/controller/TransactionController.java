package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.TransactionDto;
import com.kodilla.exchangesystem.exception.UserNotFoundException;
import com.kodilla.exchangesystem.mapper.TransactionMapper;
import com.kodilla.exchangesystem.repository.TransactionRepository;
import com.kodilla.exchangesystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;
    private final TransactionMapper mapper;

    @Autowired
    public TransactionController(TransactionService service, TransactionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<TransactionDto> getTransactions() {
        return mapper.mapToTransactionDtoList(service.getTransactions());
    }

    @GetMapping(params = "userId")
    public TransactionDto getUserTransactions(@RequestParam Long userId) {
        return mapper.mapToTransactionDto(service.getTransactionByUser(userId));
    }

    @GetMapping(params = "currencySoldId")
    public TransactionDto getCurrencySoldTransactions(@RequestParam Long currencySoldId) {
        return mapper.mapToTransactionDto(service.getTransactionByCurrencySold(currencySoldId));
    }

    @GetMapping(params = {"userId, currencySoldId"})
    public TransactionDto getUserTransactionsByCurrencySold(@RequestParam Long userId,
                                                            @RequestParam Long currencySoldId) {
        return mapper.mapToTransactionDto(service.getUserTransactionByCurrencySold(userId, currencySoldId));
    }

    @GetMapping(params = "currencyBoughtId")
    public TransactionDto getCurrencyBoughtTransactions(@RequestParam Long currencyBoughtId) {
        return mapper.mapToTransactionDto(service.getTransactionByCurrencyBought(currencyBoughtId));
    }

    @GetMapping(params = {"userId, currencyBoughtId"})
    public TransactionDto getUserTransactionsByCurrencyBought(@RequestParam Long userId,
                                                              @RequestParam Long currencyBoughtId) {
        return mapper.mapToTransactionDto(service.getUserTransactionByCurrencyBought(userId, currencyBoughtId));
    }

    @GetMapping(params = {"transactionId, userId"})
    public TransactionDto getSingleUserTransaction(@RequestParam Long transactionId,
                                                   @RequestParam Long userId) {
        return mapper.mapToTransactionDto(service.getSingleUserTransaction(transactionId, userId));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public TransactionDto createTransaction(@RequestBody TransactionDto transactionDto) throws UserNotFoundException {
        return mapper.mapToTransactionDto(service.addTransaction(mapper.mapToTransaction(transactionDto)));
    }

    @PutMapping
    public TransactionDto updateTransaction(@RequestBody TransactionDto transactionDto) throws UserNotFoundException {
        return mapper.mapToTransactionDto(service.addTransaction(mapper.mapToTransaction(transactionDto)));
    }

    @DeleteMapping
    public void deleteTransaction(@RequestParam Long transactionId) {
        service.deleteTransaction(transactionId);
    }
}
