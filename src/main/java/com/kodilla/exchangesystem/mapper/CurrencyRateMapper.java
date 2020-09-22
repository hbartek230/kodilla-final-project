package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.CurrencyRate;
import com.kodilla.exchangesystem.domain.dto.CurrencyRateDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyRateMapper {

    public CurrencyRateDto mapToCurrencyRateDto(CurrencyRate currencyRate) {
        return new CurrencyRateDto(
                currencyRate.getId(),
                currencyRate.getRatesBid(),
                currencyRate.getRatesAsk()
        );
    }

    public CurrencyRate mapToCurrencyRate(CurrencyRateDto currencyRateDto) {
        return new CurrencyRate(
                currencyRateDto.getId(),
                currencyRateDto.getRatesBid(),
                currencyRateDto.getRatesAsk()
        );
    }

    public List<CurrencyRateDto> mapToCurrencyRateDtoList(List<CurrencyRate> currencyRates) {
        return currencyRates.stream()
                .map(currencyRate ->
                        new CurrencyRateDto(
                                currencyRate.getId(),
                                currencyRate.getRatesBid(),
                                currencyRate.getRatesAsk()
                        ))
                .collect(Collectors.toList());
    }
}
