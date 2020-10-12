package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.UpdatingInfo;
import com.kodilla.exchangesystem.domain.dto.UpdatingInfoDto;
import org.springframework.stereotype.Component;

@Component
public class UpdatingInfoMapper {

    public UpdatingInfo mapToUpdatingInfo(UpdatingInfoDto updatingInfoDto) {
        return new UpdatingInfo(
                updatingInfoDto.getTimeStamp(),
                updatingInfoDto.getUpdatingClassName());
    }

    public UpdatingInfoDto mapToUpdatingInfoDto(UpdatingInfo updatingInfo) {
        return new UpdatingInfoDto(
                updatingInfo.getTimeStamp(),
                updatingInfo.getUpdatingClassName()
        );
    }
}
