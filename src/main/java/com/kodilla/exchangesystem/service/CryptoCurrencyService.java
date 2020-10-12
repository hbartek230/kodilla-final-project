package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.CryptoCurrency;
import com.kodilla.exchangesystem.exception.CryptoCurrencyNotFoundException;
import com.kodilla.exchangesystem.repository.CryptoCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoCurrencyService {

    private final CryptoCurrencyRepository repository;

    @Autowired
    public CryptoCurrencyService(CryptoCurrencyRepository repository) {
        this.repository = repository;
    }

    public List<CryptoCurrency> getCryptoCurrencies() {
        return repository.findAll();
    }

    public CryptoCurrency getCryptoCurrency(Long cryptoCurrencyId) throws CryptoCurrencyNotFoundException {
        return repository.findById(cryptoCurrencyId).orElseThrow(CryptoCurrencyNotFoundException::new);
    }

    public void addCryptoCurrency(CryptoCurrency cryptoCurrency) {
        repository.save(cryptoCurrency);
    }

    public void deleteCryptoCurrency(Long cryptoCurrencyId) {
        repository.deleteById(cryptoCurrencyId);
    }
}
