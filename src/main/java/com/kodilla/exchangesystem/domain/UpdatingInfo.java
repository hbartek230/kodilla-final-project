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
public class UpdatingInfo {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column
    private LocalDate timeStamp;

    @Column
    private String updatingClassName;

    public UpdatingInfo(LocalDate timeStamp, String updatingInfo) {
        this.timeStamp = timeStamp;
        this.updatingClassName = updatingClassName;
    }
}
