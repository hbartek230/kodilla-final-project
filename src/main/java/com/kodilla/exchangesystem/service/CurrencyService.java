package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.Currency;
import com.kodilla.exchangesystem.exception.CurrencyNotFoundException;
import com.kodilla.exchangesystem.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository repository;

    @Autowired
    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    public List<Currency> getCurrencies() {
        return repository.findAll();
    }

    public Currency getSingleCurrency(Long currencyId) throws CurrencyNotFoundException {
        return repository.findById(currencyId).orElseThrow(CurrencyNotFoundException::new);
    }

    public Currency getCurrencyByCode(String currencyCode) {
        return repository.findByCurrencyCode(currencyCode);
    }

    public void addCurrency(Currency currency) {
        repository.save(currency);
    }

    public void deleteCurrency(Long currencyId) {
        repository.deleteById(currencyId);
    }
}
