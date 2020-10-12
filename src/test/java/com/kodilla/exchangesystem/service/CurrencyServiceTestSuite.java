package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.Currency;
import com.kodilla.exchangesystem.domain.CurrencyRate;
import com.kodilla.exchangesystem.exception.CurrencyNotFoundException;
import com.kodilla.exchangesystem.repository.CurrencyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyServiceTestSuite {

    @Autowired
    private CurrencyService service;

    @MockBean
    private CurrencyRepository repository;

    @Mock
    private CurrencyRate currencyRate;

    @Test
    public void should_returnEmptyCurrencyList() {
        // given
        List<Currency> expectedList = Collections.emptyList();
        when(repository.findAll()).thenReturn(Collections.emptyList());

        // when
        List<Currency> testedList = service.getCurrencies();

        // then
        assertEquals(testedList.size(), expectedList.size());
    }

    @Test
    public void should_returnOneElementCurrencyList() {
        // given
        Currency currency = new Currency(1L, "Dolar", "USD", currencyRate);
        List<Currency> expectedList = Collections.singletonList(currency);
        when(repository.findAll()).thenReturn(expectedList);

        // when
        List<Currency> testedList = service.getCurrencies();

        // then
        assertEquals(testedList.size(), expectedList.size());
        assertEquals(testedList.get(0).getCurrencyName(), expectedList.get(0).getCurrencyName());
        assertEquals(testedList.get(0).getCurrencyCode(), expectedList.get(0).getCurrencyCode());
    }

    @Test
    public void should_returnSpecifiedIdElementFromCurrencyList() throws CurrencyNotFoundException {
        // given
        Currency currency = new Currency(2L, "Euro", "EUR", currencyRate);
        when(repository.findById(anyLong())).thenReturn(Optional.of(currency));

        // when
        Currency testedCurrency = service.getSingleCurrency(anyLong());

        // then
        assertEquals(testedCurrency.getId(), currency.getId());
        assertEquals(testedCurrency.getCurrencyName(), currency.getCurrencyName());
        assertEquals(testedCurrency.getCurrencyCode(), currency.getCurrencyCode());
    }

    @Test
    public void should_returnSpecifiedCurrencyCodeElementFromList() {
        // given
        Currency currency = new Currency(2L, "Euro", "EUR", currencyRate);
        when(repository.findByCurrencyCode(anyString())).thenReturn(currency);

        // when
        Currency testedCurrency = service.getCurrencyByCode(anyString());

        // then
        assertEquals(testedCurrency.getId(), currency.getId());
        assertEquals(testedCurrency.getCurrencyName(), currency.getCurrencyName());
        assertEquals(testedCurrency.getCurrencyCode(), currency.getCurrencyCode());
    }

    @Test
    public void should_addNewCurrency() {
        // given
        Currency currency = new Currency(2L, "Euro", "EUR", currencyRate);
        when(repository.save(currency)).thenReturn(currency);

        // when
        service.addCurrency(currency);

        // then
        verify(repository, times(1)).save(currency);
    }

    @Test
    public void should_deleteCurrency() {
        // given
        doNothing().when(repository).deleteById(anyLong());

        // when
        service.deleteCurrency(anyLong());

        // then
        verify(repository, times(1)).deleteById(anyLong());
    }
}
