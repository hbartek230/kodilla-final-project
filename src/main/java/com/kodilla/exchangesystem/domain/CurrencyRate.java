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
public class CurrencyRate {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    private double ratesBid;

    @Column
    private double ratesAsk;
}
