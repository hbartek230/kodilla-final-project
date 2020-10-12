package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.HistoricalCryptoCurrencyValues;
import com.kodilla.exchangesystem.domain.HistoricalCurrencyValues;
import com.kodilla.exchangesystem.domain.dto.HistoricalCryptoCurrencyValuesDto;
import com.kodilla.exchangesystem.domain.dto.HistoricalCurrencyValuesDto;
import com.kodilla.exchangesystem.mapper.HistoricalCryptoCurrencyValuesMapper;
import com.kodilla.exchangesystem.repository.HistoricalCryptoCurrencyValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricalCryptoCurrencyValuesService {

    private final HistoricalCryptoCurrencyValuesRepository repository;
    private final HistoricalCryptoCurrencyValuesMapper mapper;

    @Autowired
    public HistoricalCryptoCurrencyValuesService(HistoricalCryptoCurrencyValuesRepository repository,
                                                 HistoricalCryptoCurrencyValuesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<HistoricalCryptoCurrencyValues> getHistoricalCryptoCurrencyValues() {
        return repository.findAll();
    }

    public HistoricalCryptoCurrencyValues addHistoricalCurrencyValue(HistoricalCryptoCurrencyValuesDto currency) {
        return repository.save(mapper.mapToHistoricalCryptoCurrencyValues(currency));
    }
}
