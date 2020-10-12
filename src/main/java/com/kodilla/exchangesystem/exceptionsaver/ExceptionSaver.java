package com.kodilla.exchangesystem.exceptionsaver;

import com.kodilla.exchangesystem.domain.Exception;
import com.kodilla.exchangesystem.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ExceptionSaver {

    private final ExceptionService service;

    @Autowired
    public ExceptionSaver(ExceptionService service) {
        this.service = service;
    }

    public void saveExceptionToDatabase(String message) {
        service.addExceptionToDatabase(new Exception(LocalDate.now(), message));
    }
}
