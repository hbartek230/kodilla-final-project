package com.kodilla.exchangesystem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String login;

    @Column
    private String password;

    @OneToMany(
            targetEntity = Transaction.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Transaction> transactions;

    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
}
