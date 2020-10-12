package com.kodilla.exchangesystem.service;

import com.kodilla.exchangesystem.domain.User;
import com.kodilla.exchangesystem.exception.UserNotFoundException;
import com.kodilla.exchangesystem.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestSuite {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    @Test
    public void should_returnEmptyUserList() {
        //given
        List<User> expectedList = Collections.emptyList();

        // when
        List<User> testedList = service.getUsers();

        // then
        assertEquals(expectedList, testedList);

        // cleanUp
        repository.deleteAll();
    }

    @Test
    public void should_returnOneElementList() {
        // given
        User user = new User(1L, "tested_user", "tested_password");
        List<User> expectedList = Collections.singletonList(user);
        service.addUser(user);

        // when
        List<User> testedList = service.getUsers();

        // then
        assertEquals(expectedList.size(), testedList.size());
        assertEquals(expectedList.get(0).getLogin(), testedList.get(0).getLogin());

        // cleanUp
        repository.deleteAll();
    }

    @Test
    public void should_returnSpecifiedIdElementFromList() throws UserNotFoundException {
        User user = new User(1L, "tested_user", "tested_password");
        service.addUser(user);

        // when
        User testedUser = service.getUser(repository.findByLogin(user.getLogin())
                .orElseThrow(UserNotFoundException::new).getId());

        // then
        assertEquals(testedUser.getLogin(), user.getLogin());
        assertEquals(testedUser.getPassword(), user.getPassword());

        // cleanUp
        repository.deleteAll();
    }

    @Test
    public void should_removeSpecifiedIdElementFromList() throws UserNotFoundException {
        User user = new User(1L, "test_user", "test_password");
        List<User> expectedList = Collections.emptyList();
        service.addUser(user);

        // when
        service.deleteUser(repository.findByLogin(user.getLogin()).orElseThrow(UserNotFoundException::new).getId());
        List<User> testedList = service.getUsers();

        // then
        assertEquals(expectedList.size(), testedList.size());

        //cleanUp
        repository.deleteAll();
    }
}
