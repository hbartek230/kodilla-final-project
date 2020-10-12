package com.kodilla.exchangesystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExceptionDto {

    private Long id;
    private LocalDate timeStamp;
    private String exceptionKind;

    public ExceptionDto(LocalDate timeStamp, String exceptionKind) {
        this.timeStamp = timeStamp;
        this.exceptionKind = exceptionKind;
    }
}
