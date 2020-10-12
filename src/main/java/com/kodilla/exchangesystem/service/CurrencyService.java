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

    public Currency getCurrencyByCode(String currencyCode) throws CurrencyNotFoundException {
        return repository.findByCurrencyCode(currencyCode).orElseThrow(CurrencyNotFoundException::new);
    }

    public Currency addCurrency(Currency currency) {
        if (repository.findByCurrencyCode(currency.getCurrencyCode()).isPresent()) {
            return repository.save(repository.findByCurrencyCode(currency.getCurrencyCode()).get());
        } else {
            return repository.save(currency);
        }
    }

    public void deleteCurrency(Long currencyId) {
        repository.deleteById(currencyId);
    }
}
