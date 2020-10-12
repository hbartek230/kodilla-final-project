package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.HistoricalCurrencyValues;
import com.kodilla.exchangesystem.domain.dto.HistoricalCurrencyValuesDto;
import com.kodilla.exchangesystem.mapper.HistoricalCurrencyValuesMapper;
import com.kodilla.exchangesystem.repository.HistoricalCurrencyValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricalCurrencyValuesService {

    private final HistoricalCurrencyValuesRepository repository;

    @Autowired
    public HistoricalCurrencyValuesService(HistoricalCurrencyValuesRepository repository) {
        this.repository = repository;
    }

    public List<HistoricalCurrencyValues> getHistoricalCurrencyValues() {
        return repository.findAll();
    }

    public HistoricalCurrencyValues addHistoricalCurrencyValue(HistoricalCurrencyValues currency) {
        return repository.save(currency);
    }
}
