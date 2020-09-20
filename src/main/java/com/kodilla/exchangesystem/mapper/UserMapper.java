package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.User;
import com.kodilla.exchangesystem.domain.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserDto userDto) {
        return new User(
                userDto.getLogin(),
                userDto.getPassword()
        );
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getLogin(),
                user.getPassword()
        );
    }
}
