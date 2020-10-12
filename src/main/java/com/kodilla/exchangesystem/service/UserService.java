package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.User;
import com.kodilla.exchangesystem.exception.UserNotFoundException;
import com.kodilla.exchangesystem.repository.UserRepository;
import com.kodilla.exchangesystem.useCases.CheckIfUserExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final CheckIfUserExist checkUserUseCase;

    @Autowired
    public UserService(UserRepository repository, CheckIfUserExist checkUserUseCase) {
        this.repository = repository;
        this.checkUserUseCase = checkUserUseCase;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUser(Long userId) throws UserNotFoundException {
        return repository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public User addUser(User user) {
        return checkUserUseCase.invoke(user);
    }

    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }
}
