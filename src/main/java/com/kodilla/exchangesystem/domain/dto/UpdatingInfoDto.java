package com.kodilla.exchangesystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatingInfoDto {

    private Long id;
    private LocalDate timeStamp;
    private String updatingClassName;

    public UpdatingInfoDto(LocalDate timeStamp, String updatingClassName) {
        this.timeStamp = timeStamp;
        this.updatingClassName = updatingClassName;
    }
}
