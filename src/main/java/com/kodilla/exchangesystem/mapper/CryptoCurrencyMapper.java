package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.CryptoCurrency;
import com.kodilla.exchangesystem.domain.dto.CryptoCurrencyDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CryptoCurrencyMapper {

    public CryptoCurrencyDto mapToCryptoCurrencyDto(CryptoCurrency cryptoCurrency) {
        return new CryptoCurrencyDto(
                cryptoCurrency.getId(),
                cryptoCurrency.getCurrencyName(),
                cryptoCurrency.getCurrencyValue()
        );
    }

    public CryptoCurrency mapToCryptoCurrency(CryptoCurrencyDto cryptoCurrencyDto) {
        return new CryptoCurrency(
                cryptoCurrencyDto.getId(),
                cryptoCurrencyDto.getCurrencyName(),
                cryptoCurrencyDto.getCurrencyValue()
        );
    }

    public List<CryptoCurrencyDto> mapToCryptoCurrencyDtoList(List<CryptoCurrency> cryptoCurrencies) {
        return cryptoCurrencies.stream()
                .map(cryptoCurrency ->
                        new CryptoCurrencyDto(
                                cryptoCurrency.getId(),
                                cryptoCurrency.getCurrencyName(),
                                cryptoCurrency.getCurrencyValue()
                        ))
                .collect(Collectors.toList());
    }
}
