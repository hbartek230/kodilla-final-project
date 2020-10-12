package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.Currency;
import com.kodilla.exchangesystem.domain.CurrencyRate;
import com.kodilla.exchangesystem.domain.dto.CurrencyDto;
import com.kodilla.exchangesystem.domain.dto.CurrencyRateDto;
import com.kodilla.exchangesystem.exception.CurrencyRateNotFoundException;
import com.kodilla.exchangesystem.repository.CurrencyRateRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyMapperTestSuite {

    @Autowired
    private CurrencyMapper mapper;

    @MockBean
    private CurrencyRateRepository currencyRateRepository;

    @Mock
    private CurrencyRate currencyRate;

    @Mock
    private CurrencyRateDto currencyRateDto;

    @Test
    public void should_mapToCurrencyDto() {
        // given
        Currency currency = new Currency(1L, "Dolar", "USD", currencyRate);

        // when
        CurrencyDto currencyDto = mapper.mapToCurrencyDto(currency);

        // then
        assertEquals(currencyDto.getId(), currency.getId());
        assertEquals(currencyDto.getCurrencyName(), currency.getCurrencyName());
        assertEquals(currencyDto.getCurrencyCode(), currency.getCurrencyCode());
    }

    @Test
    public void should_mapToCurrency() throws CurrencyRateNotFoundException {
        // given
        CurrencyDto currencyDto = new CurrencyDto(1L, "Dolar", "USD", currencyRateDto);
        when(currencyRateRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(currencyRate));

        // when
        Currency currency = mapper.mapToCurrency(currencyDto);

        // then
        assertEquals(currency.getId(), currencyDto.getId());
        assertEquals(currency.getCurrencyName(), currencyDto.getCurrencyName());
        assertEquals(currency.getCurrencyCode(), currencyDto.getCurrencyCode());
    }

    @Test
    public void should_mapToCurrencyDtoList() {
        // given
        Currency currency = new Currency(1L, "Dolar", "USD", currencyRate);
        List<Currency> currencyList = Collections.singletonList(currency);

        // when
        List<CurrencyDto> currencyDtoList = mapper.mapToCurrencyDtoList(currencyList);

        // then
        currencyDtoList.forEach(currencyDto -> {
            assertEquals(currencyDto.getId(), currencyList.get(0).getId());
            assertEquals(currencyDto.getCurrencyName(), currencyList.get(0).getCurrencyName());
            assertEquals(currencyDto.getCurrencyCode(), currencyList.get(0).getCurrencyCode());
        });
    }
}
