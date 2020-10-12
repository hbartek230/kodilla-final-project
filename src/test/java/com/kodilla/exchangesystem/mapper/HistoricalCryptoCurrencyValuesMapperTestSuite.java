package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.HistoricalCryptoCurrencyValues;
import com.kodilla.exchangesystem.domain.dto.HistoricalCryptoCurrencyValuesDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoricalCryptoCurrencyValuesMapperTestSuite {

    @Autowired
    private HistoricalCryptoCurrencyValuesMapper mapper;

    @Test
    public void should_mapToHistoricalCryptoCurrencyValueDto() {
        // given
        HistoricalCryptoCurrencyValues value = new HistoricalCryptoCurrencyValues(1L, LocalDate.now(), "BTC", 1.0);

        // when
        HistoricalCryptoCurrencyValuesDto valueDto = mapper.mapToHistoricalCryptoCurrencyValuesDto(value);

        // the
        assertEquals(value.getTimeStamp(), valueDto.getTimeStamp());
        assertEquals(value.getCurrencyName(), valueDto.getCurrencyName());
        assertEquals(value.getCurrencyValue(), valueDto.getCurrencyValue(), 0.01);
    }

    @Test
    public void should_mapToHistoricalCryptoCurrencyValue() {
        // given
        HistoricalCryptoCurrencyValuesDto valueDto = new HistoricalCryptoCurrencyValuesDto(1L, LocalDate.now(), "BTC", 1.0);

        // when
        HistoricalCryptoCurrencyValues value = mapper.mapToHistoricalCryptoCurrencyValues(valueDto);

        // then
        assertEquals(valueDto.getTimeStamp(), value.getTimeStamp());
        assertEquals(valueDto.getCurrencyName(), value.getCurrencyName());
        assertEquals(valueDto.getCurrencyValue(), value.getCurrencyValue(), 0.01);
    }
}
