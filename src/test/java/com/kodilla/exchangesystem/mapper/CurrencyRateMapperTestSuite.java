package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.CurrencyRate;
import com.kodilla.exchangesystem.domain.dto.CurrencyRateDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyRateMapperTestSuite {

    @Autowired
    private CurrencyRateMapper mapper;

    @Test
    public void should_mapToCurrencyRateDto() {
        // given
        CurrencyRate currencyRate = new CurrencyRate(1L, 4.3, 4.4);

        // when
        CurrencyRateDto currencyRateDto = mapper.mapToCurrencyRateDto(currencyRate);

        // then
        assertEquals(currencyRate.getId(), currencyRateDto.getId());
        assertEquals(currencyRate.getRatesAsk(), currencyRateDto.getRatesAsk(), 0.01);
        assertEquals(currencyRate.getRatesBid(), currencyRateDto.getRatesBid(), 0.01);
    }

    @Test
    public void should_mapToCurrencyRate() {
        // given
        CurrencyRateDto currencyRateDto = new CurrencyRateDto(1L, 4.3, 4.4);

        // when
        CurrencyRate currencyRate = mapper.mapToCurrencyRate(currencyRateDto);

        // then
        assertEquals(currencyRateDto.getId(), currencyRate.getId());
        assertEquals(currencyRateDto.getRatesAsk(), currencyRate.getRatesAsk(), 0.01);
        assertEquals(currencyRateDto.getRatesBid(), currencyRate.getRatesBid(), 0.01);
    }

    @Test
    public void should_mapToCurrencyRateDtoList() {
        // given
        CurrencyRate currencyRate = new CurrencyRate(1L, 4.3, 4.4);
        List<CurrencyRate> currencyRateList = Collections.singletonList(currencyRate);

        // when
        List<CurrencyRateDto> currencyRateDtoList = mapper.mapToCurrencyRateDtoList(currencyRateList);

        // then
        currencyRateDtoList.forEach(currencyRateDto -> {
            assertEquals(currencyRateDto.getId(), currencyRateList.get(0).getId());
            assertEquals(currencyRateDto.getRatesAsk(), currencyRateList.get(0).getRatesAsk(), 0.01);
            assertEquals(currencyRateDto.getRatesBid(), currencyRateList.get(0).getRatesBid(), 0.01);
        });
    }
}
