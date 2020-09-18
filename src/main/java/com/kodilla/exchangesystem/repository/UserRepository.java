package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, Long> {
}
