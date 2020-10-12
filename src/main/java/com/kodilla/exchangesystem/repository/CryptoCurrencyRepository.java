package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {

    Optional<CryptoCurrency> findByCurrencyName(String currencyName);
}
