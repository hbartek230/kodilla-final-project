package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.HistoricalCryptoCurrencyValues;
import com.kodilla.exchangesystem.repository.HistoricalCryptoCurrencyValuesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HistoricalCryptoCurrencyValuesServiceTestSuite {

    @Autowired
    private HistoricalCryptoCurrencyValuesService service;

    @MockBean
    private HistoricalCryptoCurrencyValuesRepository repository;

    @Test
    public void should_returnEmptyHistoricalCurrencyValuesList() {
        List<HistoricalCryptoCurrencyValues> expectedList = Collections.emptyList();
        when(repository.findAll()).thenReturn(Collections.emptyList());

        // when
        List<HistoricalCryptoCurrencyValues> testedList = service.getHistoricalCryptoCurrencyValues();

        // then
        assertEquals(testedList.size(), expectedList.size());
    }

    @Test
    public void should_returnOneElementUpdatingInfoList() {
        // given
        HistoricalCryptoCurrencyValues value = new HistoricalCryptoCurrencyValues(1L, LocalDate.now(), "BTC", 1.0);
        List<HistoricalCryptoCurrencyValues> expectedList = Collections.singletonList(value);
        when(repository.findAll()).thenReturn(expectedList);

        // when
        List<HistoricalCryptoCurrencyValues> testedList = service.getHistoricalCryptoCurrencyValues();

        // then
        assertEquals(testedList.size(), expectedList.size());
        assertEquals(testedList.get(0).getId(), expectedList.get(0).getId());
        assertEquals(testedList.get(0).getTimeStamp(), expectedList.get(0).getTimeStamp());
        assertEquals(testedList.get(0).getCurrencyName(), expectedList.get(0).getCurrencyName());
        assertEquals(testedList.get(0).getCurrencyValue(), expectedList.get(0).getCurrencyValue(), 0.01);
    }

    @Test
    public void should_addNewUpdatingInfo() {
        // given
        HistoricalCryptoCurrencyValues value = new HistoricalCryptoCurrencyValues(1L, LocalDate.now(), "BTC", 1.0);
        when(repository.save(value)).thenReturn(value);

        // when
        service.addHistoricalCurrencyValue(value);

        // then
        verify(repository, times(1)).save(value);
    }
}
