package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.CurrencyRate;
import com.kodilla.exchangesystem.domain.dto.CurrencyRateDto;
import org.springframework.stereotype.Component;

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
                currencyRateDto.getRatesBid(),
                currencyRateDto.getRatesAsk()
        );
    }
}
