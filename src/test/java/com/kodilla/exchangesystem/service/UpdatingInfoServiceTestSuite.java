package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.UpdatingInfo;
import com.kodilla.exchangesystem.repository.UpdatingInfoRepository;
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
public class UpdatingInfoServiceTestSuite {

    @Autowired
    private UpdatingInfoService service;

    @MockBean
    private UpdatingInfoRepository repository;

    @Test
    public void should_returnEmptyUpdatingInfoList() {
        // given
        List<UpdatingInfo> expectedList = Collections.emptyList();
        when(repository.findAll()).thenReturn(Collections.emptyList());

        // when
        List<UpdatingInfo> testedList = service.getUpdatingInfos();

        // then
        assertEquals(testedList.size(), expectedList.size());
    }

    @Test
    public void should_returnOneElementUpdatingInfoList() {
        // given
        UpdatingInfo info = new UpdatingInfo(1L, LocalDate.now(), "Test Class");
        List<UpdatingInfo> expectedList = Collections.singletonList(info);
        when(repository.findAll()).thenReturn(expectedList);

        // when
        List<UpdatingInfo> testedList = service.getUpdatingInfos();

        // then
        assertEquals(testedList.size(), expectedList.size());
        assertEquals(testedList.get(0).getId(), expectedList.get(0).getId());
        assertEquals(testedList.get(0).getTimeStamp(), expectedList.get(0).getTimeStamp());
        assertEquals(testedList.get(0).getUpdatingClassName(), expectedList.get(0).getUpdatingClassName());
    }

    @Test
    public void should_addNewUpdatingInfo() {
        // given
        UpdatingInfo info = new UpdatingInfo(1L, LocalDate.now(), "Test Class");
        when(repository.save(info)).thenReturn(info);

        // when
        service.addUpdatingInfo(info);

        // then
        verify(repository, times(1)).save(info);
    }
}
