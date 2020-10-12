package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.Exception;
import com.kodilla.exchangesystem.repository.ExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    private final ExceptionRepository repository;

    @Autowired
    public ExceptionService(ExceptionRepository repository) {
        this.repository = repository;
    }

    public Exception addExceptionToDatabase(Exception exception) {
        return repository.save(exception);
    }
}
