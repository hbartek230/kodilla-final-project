package com.kodilla.exchangesystem.inputdata;

import com.kodilla.exchangesystem.inputdata.dbupdater.CryptoCurrencyDbUpdater;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CryptoCurrencyDbUpdaterTestSuite {

    @Autowired
    private CryptoCurrencyDbUpdater updater;

    @Test
    public void cryptoCurrencyUpdaterTest() {
        updater.addCryptoCurrencyToDatabase();
    }
}
