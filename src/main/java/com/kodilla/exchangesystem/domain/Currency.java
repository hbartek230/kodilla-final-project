package com.kodilla.exchangesystem.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Currency {
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    private String currencyName;

    @Column
    private String currencyCode;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "currencyRateId")
    private CurrencyRate currencyRate;

    public Currency(String currencyName, String currencyCode, CurrencyRate currencyRate) {
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.currencyRate = currencyRate;
    }
}
