package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.Transaction;
import com.kodilla.exchangesystem.domain.User;
import com.kodilla.exchangesystem.domain.dto.UserDto;
import com.kodilla.exchangesystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private TransactionRepository repository;

    @Autowired
    public UserMapper(TransactionRepository repository) {
        this.repository = repository;
    }

    public User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getTransactionsId().stream()
                        .map(transaction -> repository.findById(transaction))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getTransactions().stream()
                        .map(Transaction::getId)
                        .collect(Collectors.toList())
        );
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        return users.stream()
                .map(user ->
                        new UserDto(
                                user.getId(),
                                user.getLogin(),
                                user.getPassword(),
                                user.getTransactions().stream()
                                        .map(Transaction::getId)
                                        .collect(Collectors.toList())
                        ))
                .collect(Collectors.toList());
    }
}
