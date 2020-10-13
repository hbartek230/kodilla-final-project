package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.LoginInfo;
import com.kodilla.exchangesystem.domain.dto.LoginInfoDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoginInfoMapper {

    public LoginInfoDto mapToLoginInfoDto(LoginInfo info) {
        return new LoginInfoDto(
                info.getTimeStamp(),
                info.getLogin()
        );
    }

    public LoginInfo mapToLoginInfo(LoginInfoDto infoDto) {
        return new LoginInfo(
                infoDto.getTimeStamp(),
                infoDto.getLogin()
        );
    }

    public List<LoginInfoDto> mapToLoginInfoDtoList(List<LoginInfo> infos) {
        return infos.stream()
                .map(loginInfo ->
                        new LoginInfoDto(loginInfo.getTimeStamp(), loginInfo.getLogin()))
                .collect(Collectors.toList());
    }
}
