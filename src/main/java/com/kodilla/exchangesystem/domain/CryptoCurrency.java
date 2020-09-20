package com.kodilla.exchangesystem.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CryptoCurrency {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;
}
