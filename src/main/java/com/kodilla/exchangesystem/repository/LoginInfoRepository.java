package com.kodilla.exchangesystem.repository;

import com.kodilla.exchangesystem.domain.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginInfoRepository extends JpaRepository<LoginInfo, Long> {

    List<LoginInfo> findByLogin(String login);
}
