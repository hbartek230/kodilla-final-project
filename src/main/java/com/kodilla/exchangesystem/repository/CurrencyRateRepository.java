package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
}
