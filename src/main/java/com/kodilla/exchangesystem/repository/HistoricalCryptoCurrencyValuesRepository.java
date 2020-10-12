package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.HistoricalCryptoCurrencyValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalCryptoCurrencyValuesRepository extends JpaRepository<HistoricalCryptoCurrencyValues, Long> {
}
