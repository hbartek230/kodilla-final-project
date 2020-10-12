package com.kodilla.exchangesystem.useCases;

import com.kodilla.exchangesystem.domain.Currency;
import com.kodilla.exchangesystem.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCurrencyToDatabaseUseCase {

    private final CurrencyRepository repository;

    @Autowired
    public SaveCurrencyToDatabaseUseCase(CurrencyRepository repository) {
        this.repository = repository;
    }

    public Currency invoke(Currency currency) {
        if(repository.findByCurrencyCode(currency.getCurrencyCode()).isPresent()) {
            return repository.save(repository.findByCurrencyCode(currency.getCurrencyCode()).get());
        } else {
            return repository.save(currency);
        }
    }
}
