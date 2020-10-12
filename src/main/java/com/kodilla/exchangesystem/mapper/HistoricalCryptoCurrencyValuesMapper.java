package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.HistoricalCryptoCurrencyValues;
import com.kodilla.exchangesystem.domain.dto.HistoricalCryptoCurrencyValuesDto;
import org.springframework.stereotype.Component;

@Component
public class HistoricalCryptoCurrencyValuesMapper {

    public HistoricalCryptoCurrencyValuesDto mapToHistoricalCryptoCurrencyValuesDto(
            HistoricalCryptoCurrencyValues value) {
        return new HistoricalCryptoCurrencyValuesDto(
                value.getTimeStamp(),
                value.getCurrencyName(),
                value.getCurrencyValue()
        );
    }

    public HistoricalCryptoCurrencyValues mapToHistoricalCryptoCurrencyValues(HistoricalCryptoCurrencyValuesDto valueDto) {
        return new HistoricalCryptoCurrencyValues(
                valueDto.getTimeStamp(),
                valueDto.getCurrencyName(),
                valueDto.getCurrencyValue()
        );
    }
}
