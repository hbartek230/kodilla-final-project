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
public class LoginInfoDto {

    private Long id;
    private LocalDate timeStamp;
    private String login;

    public LoginInfoDto(LocalDate timeStamp, String login) {
        this.timeStamp = timeStamp;
        this.login = login;
    }
}
