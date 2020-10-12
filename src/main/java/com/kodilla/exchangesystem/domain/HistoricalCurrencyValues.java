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
public class HistoricalCurrencyValues {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    private LocalDate timeStamp;

    @Column
    private String currencyName;

    @Column
    private double currencyRateBid;

    @Column
    private double currencyRateAsk;

    public HistoricalCurrencyValues(LocalDate timeStamp, String currencyName,
                                    double currencyRateBid, double currencyRateAsk) {
        this.timeStamp = timeStamp;
        this.currencyName = currencyName;
        this.currencyRateBid = currencyRateBid;
        this.currencyRateAsk = currencyRateAsk;
    }
}
