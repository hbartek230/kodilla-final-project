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
public class TransactionDto {
    private Long transactionId;
    private LocalDate transactionDate;
    private CurrencyDto currencySold;
    private CurrencyDto currencyBought;
    private int currencySoldValue;
    private int currencyBoughtValue;
    private UserDto user;
}
