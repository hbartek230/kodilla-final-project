package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.UpdatingInfo;
import com.kodilla.exchangesystem.domain.dto.UpdatingInfoDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdatingInfoMapperTestSuite {

    @Autowired
    private UpdatingInfoMapper mapper;

    @Test
    public void should_mapToUpdatingInfoDto() {
        // given
        UpdatingInfo info = new UpdatingInfo(1L, LocalDate.now(), "Test Class");

        // when
        UpdatingInfoDto infoDto = mapper.mapToUpdatingInfoDto(info);

        // then
        assertEquals(info.getTimeStamp(), infoDto.getTimeStamp());
        assertEquals(info.getUpdatingClassName(), infoDto.getUpdatingClassName());
    }

    @Test
    public void should_mapToUpdatingInfo() {
        // given
        UpdatingInfoDto infoDto = new UpdatingInfoDto(1L, LocalDate.now(), "Test Class");

        // when
        UpdatingInfo info = mapper.mapToUpdatingInfo(infoDto);

        // then
        assertEquals(infoDto.getTimeStamp(), info.getTimeStamp());
        assertEquals(infoDto.getUpdatingClassName(), info.getUpdatingClassName());
    }
}
