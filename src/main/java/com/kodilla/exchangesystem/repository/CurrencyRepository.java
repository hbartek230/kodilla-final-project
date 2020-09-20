package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.dto.CurrencyDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyDto, Long> {
}
