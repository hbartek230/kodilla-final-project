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

    private Long id;
    private LocalDate transactionDate;
    private Long currencySoldId;
    private Long currencyBoughtId;
    private int currencySoldValue;
    private int currencyBoughtValue;
    private Long userId;
}
