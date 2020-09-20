package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.dto.TransactionDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionDto, Long> {
}
