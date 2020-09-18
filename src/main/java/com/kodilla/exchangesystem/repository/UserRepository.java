package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
