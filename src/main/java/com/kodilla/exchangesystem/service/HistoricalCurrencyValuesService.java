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
    private final HistoricalCurrencyValuesMapper mapper;

    @Autowired
    public HistoricalCurrencyValuesService(HistoricalCurrencyValuesRepository repository,
                                           HistoricalCurrencyValuesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<HistoricalCurrencyValues> getHistoricalCurrencyValues() {
        return repository.findAll();
    }

    public HistoricalCurrencyValues addHistoricalCurrencyValue(HistoricalCurrencyValuesDto currency) {
        return repository.save(mapper.mapToHistoricalCurrencyValues(currency));
    }
}
