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
    private Long currencyId;
    private String currencyName;
    private String currencyCode;
    private CurrencyRateDto currencyRates;
}
