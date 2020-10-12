package com.kodilla.exchangesystem.inputdata;

import com.kodilla.exchangesystem.inputdata.dbupdater.CurrencyDbUpdater;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyDbUpdaterTestSuite {

    @Autowired
    private CurrencyDbUpdater updater;

    @Test
    public void testDbUpdater() {
        updater.addCurrencyFromNBPToDatabase();
    }
}
