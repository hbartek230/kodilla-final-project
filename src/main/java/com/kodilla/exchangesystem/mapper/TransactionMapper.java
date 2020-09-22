package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.Transaction;
import com.kodilla.exchangesystem.domain.dto.TransactionDto;
import com.kodilla.exchangesystem.exception.UserNotFoundException;
import com.kodilla.exchangesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    private final UserRepository userRepository;

    @Autowired
    public TransactionMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getTransactionDate(),
                transaction.getCurrencySoldId(),
                transaction.getCurrencyBoughtId(),
                transaction.getCurrencySoldValue(),
                transaction.getCurrencyBoughtValue(),
                transaction.getUser().getId()
        );
    }

    public Transaction mapToTransaction(TransactionDto transactionDto) throws UserNotFoundException {
        return new Transaction(
                transactionDto.getId(),
                transactionDto.getTransactionDate(),
                transactionDto.getCurrencySoldId(),
                transactionDto.getCurrencyBoughtId(),
                transactionDto.getCurrencySoldValue(),
                transactionDto.getCurrencyBoughtValue(),
                userRepository.findById(transactionDto.getUserId()).orElseThrow(UserNotFoundException::new)
        );
    }

    public List<TransactionDto> mapToTransactionDtoList(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction ->
                        new TransactionDto(
                                transaction.getId(),
                                transaction.getTransactionDate(),
                                transaction.getCurrencySoldId(),
                                transaction.getCurrencyBoughtId(),
                                transaction.getCurrencySoldValue(),
                                transaction.getCurrencyBoughtValue(),
                                transaction.getUser().getId()
                        ))
                .collect(Collectors.toList());
    }
}
