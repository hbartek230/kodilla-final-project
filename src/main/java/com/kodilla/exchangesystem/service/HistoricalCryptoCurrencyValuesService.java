package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.HistoricalCryptoCurrencyValues;
import com.kodilla.exchangesystem.domain.dto.HistoricalCryptoCurrencyValuesDto;
import com.kodilla.exchangesystem.mapper.HistoricalCryptoCurrencyValuesMapper;
import com.kodilla.exchangesystem.repository.HistoricalCryptoCurrencyValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricalCryptoCurrencyValuesService {

    private final HistoricalCryptoCurrencyValuesRepository repository;

    @Autowired
    public HistoricalCryptoCurrencyValuesService(HistoricalCryptoCurrencyValuesRepository repository) {
        this.repository = repository;
    }

    public List<HistoricalCryptoCurrencyValues> getHistoricalCryptoCurrencyValues() {
        return repository.findAll();
    }

    public HistoricalCryptoCurrencyValues addHistoricalCurrencyValue(HistoricalCryptoCurrencyValues currency) {
        return repository.save(currency);
    }
}
