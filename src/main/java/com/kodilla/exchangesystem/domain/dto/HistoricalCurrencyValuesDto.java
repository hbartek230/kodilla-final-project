package com.kodilla.exchangesystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistoricalCurrencyValuesDto {

    private Long id;
    private LocalDate timeStamp;
    private String currencyName;
    private double currencyRateBid;
    private double currencyRateAsk;

    public HistoricalCurrencyValuesDto(LocalDate timeStamp, String currencyName,
                                       double currencyRateBid, double currencyRateAsk) {
        this.timeStamp = timeStamp;
        this.currencyName = currencyName;
        this.currencyRateBid = currencyRateBid;
        this.currencyRateAsk = currencyRateAsk;
    }
}
