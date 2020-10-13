package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.LoginInfo;
import com.kodilla.exchangesystem.repository.LoginInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginInfoService {

    private final LoginInfoRepository repository;

    @Autowired
    public LoginInfoService(LoginInfoRepository repository) {
        this.repository = repository;
    }

    public List<LoginInfo> getAllLoginInfos() {
        return repository.findAll();
    }

    public List<LoginInfo> getSingleUserLoginInfo(String login) {
        return repository.findByLogin(login);
    }

    public LoginInfo addNewLoginInfo(LoginInfo loginInfo) {
        return repository.save(loginInfo);
    }


}
