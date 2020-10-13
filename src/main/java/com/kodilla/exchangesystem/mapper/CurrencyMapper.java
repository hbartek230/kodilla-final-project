package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.Currency;
import com.kodilla.exchangesystem.domain.CurrencyRate;
import com.kodilla.exchangesystem.domain.dto.CurrencyDto;
import com.kodilla.exchangesystem.exception.CurrencyRateNotFoundException;
import com.kodilla.exchangesystem.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyMapper {

    private final CurrencyRateMapper currencyRateMapper;

    @Autowired
    public CurrencyMapper(CurrencyRateMapper currencyRateMapper) {
        this.currencyRateMapper = currencyRateMapper;
    }

    public CurrencyDto mapToCurrencyDto(Currency currency) {
        return new CurrencyDto(
                currency.getId(),
                currency.getCurrencyCode(),
                currency.getCurrencyName(),
                currencyRateMapper.mapToCurrencyRateDto(currency.getCurrencyRate())
        );
    }

    public Currency mapToCurrency(CurrencyDto currencyDto) throws CurrencyRateNotFoundException {
        return new Currency(
                currencyDto.getId(),
                currencyDto.getCurrencyName(),
                currencyDto.getCurrencyCode(),
                new CurrencyRate(
                        currencyDto.getCurrencyRate().getRatesBid(),
                        currencyDto.getCurrencyRate().getRatesAsk())
        );
    }

    public List<CurrencyDto> mapToCurrencyDtoList(List<Currency> currenciesList) {
        return currenciesList.stream()
                .map(currency ->
                        new CurrencyDto(
                                currency.getId(),
                                currency.getCurrencyCode(),
                                currency.getCurrencyName(),
                                currencyRateMapper.mapToCurrencyRateDto(currency.getCurrencyRate())
                        ))
                .collect(Collectors.toList());
    }
}
