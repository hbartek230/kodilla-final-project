package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {
}
