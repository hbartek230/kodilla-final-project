package com.kodilla.exchangesystem.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class CurrencyRate {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    private double ratesBid;

    @Column
    private double ratesAsk;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "currencyId")
    private Currency currency;

    public CurrencyRate(double ratesBid, double ratesAsk) {
        this.ratesBid = ratesBid;
        this.ratesAsk = ratesAsk;
    }
}
