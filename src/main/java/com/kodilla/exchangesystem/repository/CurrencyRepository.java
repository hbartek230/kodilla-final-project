package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Optional<Currency> findByCurrencyCode(String currencyCode);
}
