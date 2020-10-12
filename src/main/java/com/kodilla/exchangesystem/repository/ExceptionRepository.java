package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.Exception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepository extends JpaRepository<Exception, Long> {
}
