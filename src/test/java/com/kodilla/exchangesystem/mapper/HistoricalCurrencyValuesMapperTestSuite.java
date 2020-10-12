package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.HistoricalCurrencyValues;
import com.kodilla.exchangesystem.domain.dto.HistoricalCurrencyValuesDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoricalCurrencyValuesMapperTestSuite {

    @Autowired
    private HistoricalCurrencyValuesMapper mapper;

    @Test
    public void should_mapToHistoricalCurrencyValuesDto() {
        // given
        HistoricalCurrencyValues value = new HistoricalCurrencyValues(1L, LocalDate.now(), "USD", 1.0, 1.0);

        // when
        HistoricalCurrencyValuesDto valueDto = mapper.mapToHistoricalCurrencyValuesDto(value);

        // then
        assertEquals(value.getTimeStamp(), valueDto.getTimeStamp());
        assertEquals(value.getCurrencyName(), valueDto.getCurrencyName());
        assertEquals(value.getCurrencyRateBid(), valueDto.getCurrencyRateBid(), 0.01);
        assertEquals(value.getCurrencyRateAsk(), valueDto.getCurrencyRateAsk(), 0.01);
    }

    @Test
    public void should_mapToHistoricalCurrencyValues() {
        // given
        HistoricalCurrencyValuesDto valueDto = new HistoricalCurrencyValuesDto(1L, LocalDate.now(), "USD", 1.0, 1.0);

        // when
        HistoricalCurrencyValues value = mapper.mapToHistoricalCurrencyValues(valueDto);

        // then
        assertEquals(valueDto.getTimeStamp(), value.getTimeStamp());
        assertEquals(valueDto.getCurrencyName(), value.getCurrencyName());
        assertEquals(valueDto.getCurrencyRateBid(), value.getCurrencyRateBid(), 0.01);
        assertEquals(valueDto.getCurrencyRateAsk(), value.getCurrencyRateAsk(), 0.01);
    }
}
