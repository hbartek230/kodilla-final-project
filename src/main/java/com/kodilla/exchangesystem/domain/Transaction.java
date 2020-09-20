package com.kodilla.exchangesystem.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    private Long currencySoldId;

    @Column
    private Long currencyBoughtId;

    @Column
    private LocalDate transactionDate;

    @Column
    private int currencySoldValue;

    @Column
    private int currencyBoughtValue;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
