package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency findByCurrencyCode(String currencyCode);
}
