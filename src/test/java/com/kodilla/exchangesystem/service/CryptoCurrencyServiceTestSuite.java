package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.CryptoCurrency;
import com.kodilla.exchangesystem.domain.Transaction;
import com.kodilla.exchangesystem.exception.CryptoCurrencyNotFoundException;
import com.kodilla.exchangesystem.repository.CryptoCurrencyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CryptoCurrencyServiceTestSuite {

    @Autowired
    private CryptoCurrencyService service;

    @MockBean
    private CryptoCurrencyRepository repository;

    @Test
    public void should_returnEmptyCryptoCurrencyList() {
        // given
        List<CryptoCurrency> expectedList = Collections.emptyList();
        when(repository.findAll()).thenReturn(Collections.emptyList());

        // when
        List<CryptoCurrency> testedList = service.getCryptoCurrencies();

        // then
        assertEquals(testedList.size(), expectedList.size());
    }

    @Test
    public void should_returnOneElementCryptoCurrencyList() {
        // given
        CryptoCurrency cryptoCurrency = new CryptoCurrency(1L, "Bitcoin", 132L);
        List<CryptoCurrency> expectedList = Collections.singletonList(cryptoCurrency);
        when(repository.findAll()).thenReturn(expectedList);

        // when
        List<CryptoCurrency> testedList = service.getCryptoCurrencies();

        // then
        assertEquals(testedList.size(), expectedList.size());
        assertEquals(testedList.get(0).getId(), expectedList.get(0).getId());
        assertEquals(testedList.get(0).getCurrencyName(), expectedList.get(0).getCurrencyName());
        assertEquals(testedList.get(0).getCurrencyValue(), expectedList.get(0).getCurrencyValue(), 0.01);
    }

    @Test
    public void should_returnSpecifiedIdCryptoCurrencyFromList() throws CryptoCurrencyNotFoundException {
        // given
        CryptoCurrency cryptoCurrency = new CryptoCurrency(1L, "Bitcoin", 132L);
        when(repository.findById(anyLong())).thenReturn(Optional.of(cryptoCurrency));

        // when
        CryptoCurrency testedCurrency = service.getCryptoCurrency(anyLong());

        // then
        assertEquals(cryptoCurrency.getId(), testedCurrency.getId());
        assertEquals(cryptoCurrency.getCurrencyName(), testedCurrency.getCurrencyName());
        assertEquals(cryptoCurrency.getCurrencyValue(), testedCurrency.getCurrencyValue(), 0.01);
    }

    @Test
    public void should_addNewCryptoCurrency() {
        // given
        CryptoCurrency cryptoCurrency = new CryptoCurrency(1L, "Bitcoin", 132L);
        when(repository.save(cryptoCurrency)).thenReturn(cryptoCurrency);

        // when
        service.addCryptoCurrency(cryptoCurrency);

        // then
        verify(repository, times(1)).save(cryptoCurrency);
    }

    @Test
    public void should_deleteTransaction() {
        // given
        doNothing().when(repository).deleteById(anyLong());

        // when
        service.deleteCryptoCurrency(anyLong());

        // then
        verify(repository, times(1)).deleteById(anyLong());
    }
}
