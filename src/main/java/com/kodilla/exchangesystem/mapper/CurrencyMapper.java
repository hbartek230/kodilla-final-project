package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.Currency;
import com.kodilla.exchangesystem.domain.dto.CurrencyDto;
import com.kodilla.exchangesystem.exception.CurrencyRateNotFoundException;
import com.kodilla.exchangesystem.repository.CurrencyRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CurrencyMapper {

    private final CurrencyRateRepository currencyRateRepository;

    @Autowired
    public CurrencyMapper(CurrencyRateRepository currencyRateRepository) {
        this.currencyRateRepository = currencyRateRepository;
    }

    public CurrencyDto mapToCurrencyDto(Currency currency) {
        return new CurrencyDto(
                currency.getId(),
                currency.getCurrencyName(),
                currency.getCurrencyCode(),
                currency.getCurrencyRate().getId()
        );
    }

    public Currency mapToCurrency(CurrencyDto currencyDto) throws CurrencyRateNotFoundException {
        return new Currency(
                currencyDto.getId(),
                currencyDto.getCurrencyName(),
                currencyDto.getCurrencyCode(),
                currencyRateRepository.findById(currencyDto.getCurrencyRateId())
                        .orElseThrow(CurrencyRateNotFoundException::new)
        );
    }

    public List<CurrencyDto> mapToCurrencyDtoList(List<Currency> currenciesList) {
        return currenciesList.stream()
                .map(currency ->
                        new CurrencyDto(
                                currency.getId(),
                                currency.getCurrencyName(),
                                currency.getCurrencyCode(),
                                currency.getCurrencyRate().getId()
                        ))
                .collect(Collectors.toList());
    }
}
