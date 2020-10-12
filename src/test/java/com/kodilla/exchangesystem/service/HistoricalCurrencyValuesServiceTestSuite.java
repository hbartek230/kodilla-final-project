package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.HistoricalCurrencyValues;
import com.kodilla.exchangesystem.domain.UpdatingInfo;
import com.kodilla.exchangesystem.repository.HistoricalCurrencyValuesRepository;
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
public class HistoricalCurrencyValuesServiceTestSuite {

    @Autowired
    private HistoricalCurrencyValuesService service;

    @MockBean
    private HistoricalCurrencyValuesRepository repository;

    @Test
    public void should_returnEmptyHistoricalCurrencyValuesList() {
        List<HistoricalCurrencyValues> expectedList = Collections.emptyList();
        when(repository.findAll()).thenReturn(Collections.emptyList());

        // when
        List<HistoricalCurrencyValues> testedList = service.getHistoricalCurrencyValues();

        // then
        assertEquals(testedList.size(), expectedList.size());
    }

    @Test
    public void should_returnOneElementUpdatingInfoList() {
        // given
        HistoricalCurrencyValues value = new HistoricalCurrencyValues(1L, LocalDate.now(), "USD", 1.0, 1.0);
        List<HistoricalCurrencyValues> expectedList = Collections.singletonList(value);
        when(repository.findAll()).thenReturn(expectedList);

        // when
        List<HistoricalCurrencyValues> testedList = service.getHistoricalCurrencyValues();

        // then
        assertEquals(testedList.size(), expectedList.size());
        assertEquals(testedList.get(0).getId(), expectedList.get(0).getId());
        assertEquals(testedList.get(0).getTimeStamp(), expectedList.get(0).getTimeStamp());
        assertEquals(testedList.get(0).getCurrencyName(), expectedList.get(0).getCurrencyName());
        assertEquals(testedList.get(0).getCurrencyRateBid(), expectedList.get(0).getCurrencyRateBid(), 0.01);
        assertEquals(testedList.get(0).getCurrencyRateAsk(), expectedList.get(0).getCurrencyRateAsk(), 0.01);
    }

    @Test
    public void should_addNewUpdatingInfo() {
        // given
        HistoricalCurrencyValues value = new HistoricalCurrencyValues(1L, LocalDate.now(), "USD", 1.0, 1.0);
        when(repository.save(value)).thenReturn(value);

        // when
        service.addHistoricalCurrencyValue(value);

        // then
        verify(repository, times(1)).save(value);
    }
}
