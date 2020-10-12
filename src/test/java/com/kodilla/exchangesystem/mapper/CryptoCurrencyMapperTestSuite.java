package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.CryptoCurrency;
import com.kodilla.exchangesystem.domain.dto.CryptoCurrencyDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CryptoCurrencyMapperTestSuite {

    @Autowired
    private CryptoCurrencyMapper mapper;

    @Test
    public void should_mapToCryptoCurrencyDto() {
        // given
        CryptoCurrency cryptoCurrency = new CryptoCurrency(1L, "Bitcoin", 132L);

        // when
        CryptoCurrencyDto cryptoCurrencyDto = mapper.mapToCryptoCurrencyDto(cryptoCurrency);

        // then
        assertEquals(cryptoCurrencyDto.getCurrencyName(), cryptoCurrency.getCurrencyName());
        assertEquals(cryptoCurrencyDto.getCurrencyValue(), cryptoCurrency.getCurrencyValue(), 0.01);
    }

    @Test
    public void should_mapToCryptoCurrency() {
        // given
        CryptoCurrencyDto cryptoCurrencyDto = new CryptoCurrencyDto(1L, "Bitcoin", 132L);

        // when
        CryptoCurrency cryptoCurrency = mapper.mapToCryptoCurrency(cryptoCurrencyDto);

        // then
        assertEquals(cryptoCurrency.getCurrencyName(), cryptoCurrencyDto.getCurrencyName());
        assertEquals(cryptoCurrency.getCurrencyValue(), cryptoCurrencyDto.getCurrencyValue(), 0.01);
    }

    @Test
    public void should_mapToCryptoCurrencyDtoList() {
        // given
        CryptoCurrency cryptoCurrency = new CryptoCurrency(1L, "Bitcoin", 132L);
        List<CryptoCurrency> cryptoCurrencyList = Collections.singletonList(cryptoCurrency);

        // when
        List<CryptoCurrencyDto> cryptoCurrencyDtoList = mapper.mapToCryptoCurrencyDtoList(cryptoCurrencyList);

        // then
        cryptoCurrencyDtoList.forEach(cryptoCurrencyDto -> {
            assertEquals(cryptoCurrencyDto.getCurrencyName(), cryptoCurrencyList.get(0).getCurrencyName());
            assertEquals(cryptoCurrencyDto.getCurrencyValue(), cryptoCurrencyList.get(0).getCurrencyValue(), 0.01);
        });
    }
}
