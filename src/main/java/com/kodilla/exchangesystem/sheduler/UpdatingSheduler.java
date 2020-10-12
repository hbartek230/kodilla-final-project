package com.kodilla.exchangesystem.sheduler;

import com.kodilla.exchangesystem.inputdata.dbupdater.CryptoCurrencyDbUpdater;
import com.kodilla.exchangesystem.inputdata.dbupdater.CurrencyDbUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UpdatingSheduler {

    private final CurrencyDbUpdater currencyUpdater;
    private final CryptoCurrencyDbUpdater cryptoCurrencyUpdater;

    @Autowired
    public UpdatingSheduler(CurrencyDbUpdater currencyUpdater, CryptoCurrencyDbUpdater cryptoCurrencyUpdater) {
        this.currencyUpdater = currencyUpdater;
        this.cryptoCurrencyUpdater = cryptoCurrencyUpdater;
    }

    @Scheduled(cron = "0 0 18 * * *")
    public void updateDbInfos() {
        currencyUpdater.addCurrencyFromNBPToDatabase();
        cryptoCurrencyUpdater.addCryptoCurrencyToDatabase();
    }
}
