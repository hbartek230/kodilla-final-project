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
public class HistoricalCryptoCurrencyValuesDto {

    private Long id;
    private LocalDate timeStamp;
    private String currencyName;
    private double currencyValue;

    public HistoricalCryptoCurrencyValuesDto(LocalDate timeStamp, String currencyName, double currencyValue) {
        this.timeStamp = timeStamp;
        this.currencyName = currencyName;
        this.currencyValue = currencyValue;
    }
}
