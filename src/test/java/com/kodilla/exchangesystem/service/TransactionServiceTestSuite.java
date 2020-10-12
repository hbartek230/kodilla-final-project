package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.Transaction;
import com.kodilla.exchangesystem.domain.User;
import com.kodilla.exchangesystem.repository.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTestSuite {

    @Autowired
    private TransactionService service;

    @MockBean
    private TransactionRepository repository;

    @Mock
    private User user;

    @Test
    public void should_returnEmptyTransactionsList() {
        // given
        List<Transaction> expectedList = Collections.emptyList();
        when(repository.findAll()).thenReturn(Collections.emptyList());

        // when
        List<Transaction> testedList = service.getTransactions();

        // then
        assertEquals(testedList.size(), expectedList.size());
    }

    @Test
    public void should_returnOneElementTransactionsList() {
        // given
        Transaction transaction = new Transaction(1L, LocalDate.now(), 1L, 1L, 12, 15, user);
        List<Transaction> expectedList = Collections.singletonList(transaction);
        when(repository.findAll()).thenReturn(expectedList);

        // when
        List<Transaction> testedList = service.getTransactions();

        // then
        assertEquals(testedList.size(), expectedList.size());
        assertEquals(testedList.get(0).getId(), expectedList.get(0).getId());
        assertEquals(testedList.get(0).getTransactionDate(), expectedList.get(0).getTransactionDate());
        assertEquals(testedList.get(0).getCurrencySoldId(), expectedList.get(0).getCurrencySoldId());
        assertEquals(testedList.get(0).getCurrencyBoughtId(), expectedList.get(0).getCurrencyBoughtId());
        assertEquals(testedList.get(0).getCurrencySoldValue(), expectedList.get(0).getCurrencySoldValue());
        assertEquals(testedList.get(0).getCurrencyBoughtValue(), expectedList.get(0).getCurrencyBoughtValue());
    }

    @Test
    public void should_returnSpecifiedUserIdElementFromTransactionsList() {
        // given
        Transaction transaction = new Transaction(1L, LocalDate.now(), 1L, 1L, 12, 15, user);
        when(repository.findByUserId(anyLong())).thenReturn(transaction);

        // when
        Transaction testedTransaction = service.getTransactionByUser(anyLong());

        // then
        assertEquals(testedTransaction.getId(), transaction.getId());
        assertEquals(testedTransaction.getTransactionDate(), transaction.getTransactionDate());
        assertEquals(testedTransaction.getCurrencySoldId(), transaction.getCurrencySoldId());
        assertEquals(testedTransaction.getCurrencyBoughtId(), transaction.getCurrencyBoughtId());
        assertEquals(testedTransaction.getCurrencySoldValue(), transaction.getCurrencySoldValue());
        assertEquals(testedTransaction.getCurrencyBoughtValue(), transaction.getCurrencyBoughtValue());
    }

    @Test
    public void should_returnSpecifiedCurrencySoldIdElementFromTransactionsList() {
        // given
        Transaction transaction = new Transaction(1L, LocalDate.now(), 1L, 1L, 12, 15, user);
        when(repository.findByCurrencySoldId(anyLong())).thenReturn(transaction);

        // when
        Transaction testedTransaction = service.getTransactionByCurrencySold(anyLong());

        // then
        assertEquals(testedTransaction.getId(), transaction.getId());
        assertEquals(testedTransaction.getTransactionDate(), transaction.getTransactionDate());
        assertEquals(testedTransaction.getCurrencySoldId(), transaction.getCurrencySoldId());
        assertEquals(testedTransaction.getCurrencyBoughtId(), transaction.getCurrencyBoughtId());
        assertEquals(testedTransaction.getCurrencySoldValue(), transaction.getCurrencySoldValue());
        assertEquals(testedTransaction.getCurrencyBoughtValue(), transaction.getCurrencyBoughtValue());
    }

    @Test
    public void should_returnSpecifiedCurrencyBoughtIdElementFromTransactionsList() {
        // given
        Transaction transaction = new Transaction(1L, LocalDate.now(), 1L, 1L, 12, 15, user);
        when(repository.findByCurrencyBoughtId(anyLong())).thenReturn(transaction);

        // when
        Transaction testedTransaction = service.getTransactionByCurrencyBought(anyLong());

        // then
        assertEquals(testedTransaction.getId(), transaction.getId());
        assertEquals(testedTransaction.getTransactionDate(), transaction.getTransactionDate());
        assertEquals(testedTransaction.getCurrencySoldId(), transaction.getCurrencySoldId());
        assertEquals(testedTransaction.getCurrencyBoughtId(), transaction.getCurrencyBoughtId());
        assertEquals(testedTransaction.getCurrencySoldValue(), transaction.getCurrencySoldValue());
        assertEquals(testedTransaction.getCurrencyBoughtValue(), transaction.getCurrencyBoughtValue());
    }

    @Test
    public void should_returnSpecifiedUserIdAndCurrencySoldIdElementFromTransactionsList() {
        // given
        Transaction transaction = new Transaction(1L, LocalDate.now(), 1L, 1L, 12, 15, user);
        when(repository.findByUserIdAndCurrencySoldId(anyLong(), anyLong())).thenReturn(transaction);

        // when
        Transaction testedTransaction = service.getUserTransactionByCurrencySold(anyLong(), anyLong());

        // then
        assertEquals(testedTransaction.getId(), transaction.getId());
        assertEquals(testedTransaction.getTransactionDate(), transaction.getTransactionDate());
        assertEquals(testedTransaction.getCurrencySoldId(), transaction.getCurrencySoldId());
        assertEquals(testedTransaction.getCurrencyBoughtId(), transaction.getCurrencyBoughtId());
        assertEquals(testedTransaction.getCurrencySoldValue(), transaction.getCurrencySoldValue());
        assertEquals(testedTransaction.getCurrencyBoughtValue(), transaction.getCurrencyBoughtValue());
    }

    @Test
    public void should_returnSpecifiedUserIdAndCurrencyBoughtIdElementFromTransactionsList() {
        // given
        Transaction transaction = new Transaction(1L, LocalDate.now(), 1L, 1L, 12, 15, user);
        when(repository.findByUserIdAndCurrencyBoughtId(anyLong(), anyLong())).thenReturn(transaction);

        // when
        Transaction testedTransaction = service.getUserTransactionByCurrencyBought(anyLong(), anyLong());

        // then
        assertEquals(testedTransaction.getId(), transaction.getId());
        assertEquals(testedTransaction.getTransactionDate(), transaction.getTransactionDate());
        assertEquals(testedTransaction.getCurrencySoldId(), transaction.getCurrencySoldId());
        assertEquals(testedTransaction.getCurrencyBoughtId(), transaction.getCurrencyBoughtId());
        assertEquals(testedTransaction.getCurrencySoldValue(), transaction.getCurrencySoldValue());
        assertEquals(testedTransaction.getCurrencyBoughtValue(), transaction.getCurrencyBoughtValue());
    }

    @Test
    public void should_returnUserSingleTransactionByUserIdAndTransactionId() {
        Transaction transaction = new Transaction(1L, LocalDate.now(), 1L, 1L, 12, 15, user);
        when(repository.findByIdAndUserId(anyLong(), anyLong())).thenReturn(transaction);

        // when
        Transaction testedTransaction = service.getSingleUserTransaction(anyLong(), anyLong());

        // then
        assertEquals(testedTransaction.getId(), transaction.getId());
        assertEquals(testedTransaction.getTransactionDate(), transaction.getTransactionDate());
        assertEquals(testedTransaction.getCurrencySoldId(), transaction.getCurrencySoldId());
        assertEquals(testedTransaction.getCurrencyBoughtId(), transaction.getCurrencyBoughtId());
        assertEquals(testedTransaction.getCurrencySoldValue(), transaction.getCurrencySoldValue());
        assertEquals(testedTransaction.getCurrencyBoughtValue(), transaction.getCurrencyBoughtValue());
    }

    @Test
    public void should_addNewTransaction() {
        // given
        Transaction transaction = new Transaction(1L, LocalDate.now(), 1L, 1L, 12, 15, user);
        when(repository.save(transaction)).thenReturn(transaction);

        // when
        service.addTransaction(transaction);

        // then
        verify(repository, times(1)).save(transaction);
    }

    @Test
    public void should_deleteTransaction() {
        // given
        doNothing().when(repository).deleteById(anyLong());

        // when
        service.deleteTransaction(anyLong());

        // then
        verify(repository, times(1)).deleteById(anyLong());
    }
}
