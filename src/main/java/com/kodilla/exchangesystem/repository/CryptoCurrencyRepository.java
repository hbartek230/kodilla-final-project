package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.dto.CryptoCurrencyDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrencyDto, Long> {
}
