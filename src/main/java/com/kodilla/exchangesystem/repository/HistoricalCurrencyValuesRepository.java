package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.HistoricalCurrencyValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricalCurrencyValuesRepository extends JpaRepository<HistoricalCurrencyValues, Long> {
}
