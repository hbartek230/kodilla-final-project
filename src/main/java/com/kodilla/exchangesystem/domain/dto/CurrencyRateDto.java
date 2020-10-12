package com.kodilla.exchangesystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrencyRateDto {

    private Long id;
    private double ratesBid;
    private double ratesAsk;

    public CurrencyRateDto(double ratesBid, double ratesAsk) {
        this.ratesBid = ratesBid;
        this.ratesAsk = ratesAsk;
    }
}
