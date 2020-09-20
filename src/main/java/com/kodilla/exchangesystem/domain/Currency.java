package com.kodilla.exchangesystem.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @ManyToMany
    private List<Transaction> transactions;
}
