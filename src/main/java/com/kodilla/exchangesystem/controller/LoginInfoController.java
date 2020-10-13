package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.LoginInfoDto;
import com.kodilla.exchangesystem.mapper.LoginInfoMapper;
import com.kodilla.exchangesystem.service.LoginInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/logininfo")
public class LoginInfoController {

    private final LoginInfoService service;
    private final LoginInfoMapper mapper;

    public LoginInfoController(LoginInfoService service, LoginInfoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<LoginInfoDto> getLoginInfos() {
        return mapper.mapToLoginInfoDtoList(service.getAllLoginInfos());
    }

    @GetMapping(params = "login")
    public List<LoginInfoDto> getSingleUserLoginInfo(@RequestParam String login) {
        return mapper.mapToLoginInfoDtoList(service.getSingleUserLoginInfo(login));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public LoginInfoDto addNewLoginInfo(@RequestBody LoginInfoDto loginInfoDto) {
        return mapper.mapToLoginInfoDto(service.addNewLoginInfo(mapper.mapToLoginInfo(loginInfoDto)));
    }
}
