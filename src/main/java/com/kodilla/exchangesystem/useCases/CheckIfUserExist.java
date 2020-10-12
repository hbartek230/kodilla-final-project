package com.kodilla.exchangesystem.useCases;

import com.kodilla.exchangesystem.domain.User;
import com.kodilla.exchangesystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CheckIfUserExist {

    private final UserRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckIfUserExist.class);

    public CheckIfUserExist(UserRepository repository) {
        this.repository = repository;
    }

    public User invoke(User user) {
        if (!repository.findByLogin(user.getLogin()).isPresent()) {
            return repository.save(user);
        } else {
            LOGGER.error("User not Found");
            return null;
        }
    }
}
