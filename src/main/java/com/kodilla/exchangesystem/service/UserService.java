package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.User;
import com.kodilla.exchangesystem.domain.dto.UserDto;
import com.kodilla.exchangesystem.exception.UserNotFoundException;
import com.kodilla.exchangesystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUser(Long userId) throws UserNotFoundException {
        return repository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public void addUser(User user) {
        repository.save(user);
    }

    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }
}
