package com.kodilla.exchangesystem.aspect;

import com.kodilla.exchangesystem.domain.UpdatingInfo;
import com.kodilla.exchangesystem.service.UpdatingInfoService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    private final UpdatingInfoService service;

    @Autowired
    public Watcher(UpdatingInfoService service) {
        this.service = service;
    }

    @After("execution(* com.kodilla.exchangesystem.inputdata.dbupdater.CurrencyDbUpdater.addCurrencyFromNBPToDatabase(..))")
    public void logCurrencyValueInDatabaseUpdate() {
        UpdatingInfo info = new UpdatingInfo(LocalDate.now(), "Updating Currency Database");
        service.addUpdatingInfo(info);
    }

    @After("execution(* com.kodilla.exchangesystem.inputdata.dbupdater.CryptoCurrencyDbUpdater.addCryptoCurrencyToDatabase(..))")
    public void logCryptoCurrencyValueInDatabaseUpdate() {
        UpdatingInfo info = new UpdatingInfo(LocalDate.now(), "Updating CryptoCurrency Database");
        service.addUpdatingInfo(info);
    }
}
