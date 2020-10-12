package com.kodilla.exchangesystem.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class HistoricalCryptoCurrencyValues {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    private LocalDate timeStamp;

    @Column
    private String currencyName;

    @Column
    private double currencyValue;

    public HistoricalCryptoCurrencyValues(LocalDate timeStamp, String currencyName, double currencyValue) {
        this.timeStamp = timeStamp;
        this.currencyName = currencyName;
        this.currencyValue = currencyValue;
    }
}
