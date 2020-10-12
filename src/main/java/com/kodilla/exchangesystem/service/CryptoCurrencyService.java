package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.CryptoCurrency;
import com.kodilla.exchangesystem.domain.HistoricalCryptoCurrencyValues;
import com.kodilla.exchangesystem.domain.HistoricalCurrencyValues;
import com.kodilla.exchangesystem.exception.CryptoCurrencyNotFoundException;
import com.kodilla.exchangesystem.repository.CryptoCurrencyRepository;
import com.kodilla.exchangesystem.repository.HistoricalCryptoCurrencyValuesRepository;
import com.kodilla.exchangesystem.repository.HistoricalCurrencyValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CryptoCurrencyService {

    private final CryptoCurrencyRepository repository;
    private final HistoricalCryptoCurrencyValuesRepository historicalRepository;


    @Autowired
    public CryptoCurrencyService(CryptoCurrencyRepository repository,
                                 HistoricalCryptoCurrencyValuesRepository historicalRepository) {
        this.repository = repository;
        this.historicalRepository = historicalRepository;
    }

    public List<CryptoCurrency> getCryptoCurrencies() {
        return repository.findAll();
    }

    public CryptoCurrency getCryptoCurrency(Long cryptoCurrencyId) throws CryptoCurrencyNotFoundException {
        return repository.findById(cryptoCurrencyId).orElseThrow(CryptoCurrencyNotFoundException::new);
    }

    public CryptoCurrency addCryptoCurrency(CryptoCurrency cryptoCurrency) {
        HistoricalCryptoCurrencyValues historicalValue = new HistoricalCryptoCurrencyValues(
                LocalDate.now(),
                cryptoCurrency.getCurrencyName(),
                cryptoCurrency.getCurrencyValue()
        );
        historicalRepository.save(historicalValue);
        if (repository.findByCurrencyName(cryptoCurrency.getCurrencyName()).isPresent()) {
            return repository.save(repository.findByCurrencyName(cryptoCurrency.getCurrencyName()).get());
        } else {
            return repository.save(cryptoCurrency);
        }
    }

    public void deleteCryptoCurrency(Long cryptoCurrencyId) {
        repository.deleteById(cryptoCurrencyId);
    }
}
