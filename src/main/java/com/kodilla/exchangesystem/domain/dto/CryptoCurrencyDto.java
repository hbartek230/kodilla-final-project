package com.kodilla.exchangesystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CryptoCurrencyDto {

    private Long id;
    private String currencyName;
    private Long currencyValue;

    public CryptoCurrencyDto(String currencyName, long currencyValue) {
        this.currencyName = currencyName;
        this.currencyValue = currencyValue;
    }
}
