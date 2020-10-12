package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.Currency;
import com.kodilla.exchangesystem.domain.CurrencyRate;
import com.kodilla.exchangesystem.domain.dto.CurrencyDto;
import com.kodilla.exchangesystem.exception.CurrencyRateNotFoundException;
import com.kodilla.exchangesystem.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CurrencyMapper {

    private final CurrencyRateRepository currencyRateRepository;
    private final CurrencyRateMapper currencyRateMapper;

    @Autowired
    public CurrencyMapper(CurrencyRateRepository currencyRateRepository, CurrencyRateMapper currencyRateMapper) {
        this.currencyRateRepository = currencyRateRepository;
        this.currencyRateMapper = currencyRateMapper;
    }

    public CurrencyDto mapToCurrencyDto(Currency currency) {
        return new CurrencyDto(
                currency.getCurrencyName(),
                currency.getCurrencyCode(),
                currencyRateMapper.mapToCurrencyRateDto(currency.getCurrencyRate())
        );
    }

    public Currency mapToCurrency(CurrencyDto currencyDto) throws CurrencyRateNotFoundException {
        return new Currency(
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
                                currency.getCurrencyName(),
                                currency.getCurrencyCode(),
                                currencyRateMapper.mapToCurrencyRateDto(currency.getCurrencyRate())
                        ))
                .collect(Collectors.toList());
    }
}
