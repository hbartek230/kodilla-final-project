package com.kodilla.exchangesystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrencyDto {
    private Long id;
    private String currencyName;
    private String currencyCode;
    private CurrencyRateDto currencyRate;

    public CurrencyDto(String currencyName, String currencyCode, CurrencyRateDto currencyRate) {
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
    }
}
