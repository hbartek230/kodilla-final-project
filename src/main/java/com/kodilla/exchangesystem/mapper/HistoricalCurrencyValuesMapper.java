package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.HistoricalCurrencyValues;
import com.kodilla.exchangesystem.domain.dto.HistoricalCurrencyValuesDto;
import org.springframework.stereotype.Component;

@Component
public class HistoricalCurrencyValuesMapper {

    public HistoricalCurrencyValuesDto mapToHistoricalCurrencyValuesDto(HistoricalCurrencyValues value) {
        return new HistoricalCurrencyValuesDto(
                value.getTimeStamp(),
                value.getCurrencyName(),
                value.getCurrencyRateBid(),
                value.getCurrencyRateAsk()
        );
    }

    public HistoricalCurrencyValues mapToHistoricalCurrencyValues(HistoricalCurrencyValuesDto valueDto) {
        return new HistoricalCurrencyValues(
                valueDto.getTimeStamp(),
                valueDto.getCurrencyName(),
                valueDto.getCurrencyRateBid(),
                valueDto.getCurrencyRateAsk()
        );
    }
}
