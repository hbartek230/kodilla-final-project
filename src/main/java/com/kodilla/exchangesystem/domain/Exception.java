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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Exception {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    private LocalDate timeStamp;

    @Column
    private String exceptionKind;

    public Exception(LocalDate timeStamp, String exceptionKind) {
        this.timeStamp = timeStamp;
        this.exceptionKind = exceptionKind;
    }
}
