package com.kodilla.exchangesystem.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    private LocalDate transactionDate;

    @Column
    private Long currencySoldId;

    @Column
    private Long currencyBoughtId;

    @Column
    private int currencySoldValue;

    @Column
    private int currencyBoughtValue;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Transaction(LocalDate transactionDate, Long currencySoldId, Long currencyBoughtId, int currencySoldValue,
                       int currencyBoughtValue, User user) {
        this.transactionDate = transactionDate;
        this.currencySoldId = currencySoldId;
        this.currencyBoughtId = currencyBoughtId;
        this.currencySoldValue = currencySoldValue;
        this.currencyBoughtValue = currencyBoughtValue;
        this.user = user;
    }
}
