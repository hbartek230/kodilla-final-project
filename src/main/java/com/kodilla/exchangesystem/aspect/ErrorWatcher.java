package com.kodilla.exchangesystem.aspect;

import com.kodilla.exchangesystem.exceptionsaver.ExceptionSaver;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorWatcher {
    private final ExceptionSaver saver;

    @Autowired
    public ErrorWatcher(ExceptionSaver saver) {
        this.saver = saver;
    }

    @After("execution(* com.kodilla.exchangesystem.exception..*(..)) && target(object)")
    public void logException(Object object) {
        saver.saveExceptionToDatabase(object.getClass().getName());
    }
}
