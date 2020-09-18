package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.repository.CryptoCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CryptoCurrencyService {

    private CryptoCurrencyRepository repository;

    @Autowired
    public CryptoCurrencyService(CryptoCurrencyRepository repository) {
        this.repository = repository;
    }
}
