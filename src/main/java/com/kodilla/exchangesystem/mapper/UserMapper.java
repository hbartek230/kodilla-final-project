package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.User;
import com.kodilla.exchangesystem.domain.dto.UserDto;
import com.kodilla.exchangesystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getLogin(),
                userDto.getPassword()
        );
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getLogin(),
                user.getPassword());
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        return users.stream()
                .map(user ->
                        new UserDto(
                                user.getId(),
                                user.getLogin(),
                                user.getPassword()))
                .collect(Collectors.toList());
    }
}
