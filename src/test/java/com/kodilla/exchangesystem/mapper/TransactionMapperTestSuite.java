package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.Transaction;
import com.kodilla.exchangesystem.domain.User;
import com.kodilla.exchangesystem.domain.dto.TransactionDto;
import com.kodilla.exchangesystem.exception.UserNotFoundException;
import com.kodilla.exchangesystem.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionMapperTestSuite {

    @Autowired
    private TransactionMapper mapper;

    @MockBean
    private UserRepository userRepository;

    @Mock
    private User user;

    @Test
    public void should_mapToTransactionDto() {
        // given
        Transaction transaction = new Transaction(1L, LocalDate.now(), 1L, 1L, 12, 15, user);

        // when
        TransactionDto transactionDto = mapper.mapToTransactionDto(transaction);

        // then
        assertEquals(transaction.getId(), transactionDto.getId());
        assertEquals(transaction.getTransactionDate(), transactionDto.getTransactionDate());
        assertEquals(transaction.getCurrencySoldId(), transactionDto.getCurrencySoldId());
        assertEquals(transaction.getCurrencyBoughtId(), transactionDto.getCurrencyBoughtId());
        assertEquals(transaction.getCurrencySoldValue(), transactionDto.getCurrencySoldValue());
        assertEquals(transaction.getCurrencyBoughtValue(), transactionDto.getCurrencyBoughtValue());
    }

    @Test
    public void should_mapToTransaction() throws UserNotFoundException {
        // given
        TransactionDto transactionDto = new TransactionDto(1L, LocalDate.now(), 1L, 1L, 12, 15, 1L);
        when(userRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(user));

        // when
        Transaction transaction = mapper.mapToTransaction(transactionDto);

        // then
        assertEquals(transactionDto.getId(), transaction.getId());
        assertEquals(transactionDto.getTransactionDate(), transaction.getTransactionDate());
        assertEquals(transactionDto.getCurrencySoldId(), transaction.getCurrencySoldId());
        assertEquals(transactionDto.getCurrencyBoughtId(), transaction.getCurrencyBoughtId());
        assertEquals(transactionDto.getCurrencySoldValue(), transaction.getCurrencySoldValue());
        assertEquals(transactionDto.getCurrencyBoughtValue(), transaction.getCurrencyBoughtValue());
    }

    @Test
    public void should_MapToTransactionDtoList() {
        // given
        Transaction transaction = new Transaction(1L, LocalDate.now(), 1L, 1L, 12, 15, user);
        List<Transaction> transactions = Collections.singletonList(transaction);

        // when
        List<TransactionDto> transactionsDto = mapper.mapToTransactionDtoList(transactions);

        // then
        transactionsDto.forEach(transactionDto -> {
            assertEquals(transactionDto.getId(), transactions.get(0).getId());
            assertEquals(transactionDto.getTransactionDate(), transactions.get(0).getTransactionDate());
            assertEquals(transactionDto.getCurrencySoldId(), transactions.get(0).getCurrencySoldId());
            assertEquals(transactionDto.getCurrencyBoughtId(), transactions.get(0).getCurrencyBoughtId());
            assertEquals(transactionDto.getCurrencySoldValue(), transactions.get(0).getCurrencySoldValue());
            assertEquals(transactionDto.getCurrencyBoughtValue(), transactions.get(0).getCurrencyBoughtValue());
        });
    }
}
