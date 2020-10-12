package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.Currency;
import com.kodilla.exchangesystem.domain.HistoricalCurrencyValues;
import com.kodilla.exchangesystem.exception.CurrencyNotFoundException;
import com.kodilla.exchangesystem.repository.CurrencyRepository;
import com.kodilla.exchangesystem.repository.HistoricalCurrencyValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository repository;
    private final HistoricalCurrencyValuesRepository historicalRepository;

    @Autowired
    public CurrencyService(CurrencyRepository repository, HistoricalCurrencyValuesRepository historicalRepository) {
        this.repository = repository;
        this.historicalRepository = historicalRepository;
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
        HistoricalCurrencyValues historicalValue = new HistoricalCurrencyValues(
                LocalDate.now(),
                currency.getCurrencyName(),
                currency.getCurrencyRate().getRatesBid(),
                currency.getCurrencyRate().getRatesAsk()
        );
        historicalRepository.save(historicalValue);
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
