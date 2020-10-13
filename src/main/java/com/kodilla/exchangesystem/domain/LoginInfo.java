package com.kodilla.exchangesystem.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class LoginInfo {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    private LocalDate timeStamp;

    @Column
    private String login;

    public LoginInfo(LocalDate timeStamp, String login) {
        this.timeStamp = timeStamp;
        this.login = login;
    }
}
