package com.kodilla.exchangesystem.domain;

import javax.persistence.*;
import java.util.List;

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

}
