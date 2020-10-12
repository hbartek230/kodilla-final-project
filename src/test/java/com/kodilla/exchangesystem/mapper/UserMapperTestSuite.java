package com.kodilla.exchangesystem.mapper;

import com.kodilla.exchangesystem.domain.User;
import com.kodilla.exchangesystem.domain.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestSuite {

    @Autowired
    private UserMapper mapper;

    @Test
    public void should_mapToUserDto() {
        // given
        User user = new User(1L, "test_user", "test_password");

        // when
        UserDto userDtoAfterMap = mapper.mapToUserDto(user);

        // then
        assertEquals(user.getId(), userDtoAfterMap.getId());
        assertEquals(user.getLogin(), userDtoAfterMap.getLogin());
        assertEquals(user.getPassword(), userDtoAfterMap.getPassword());
    }

    @Test
    public void should_mapToUser() {
        // given
        UserDto userDto = new UserDto(1L, "test_user", "test_password");

        // when
        User userAfterMap = mapper.mapToUser(userDto);

        // then
        assertEquals(userDto.getId(), userAfterMap.getId());
        assertEquals(userDto.getLogin(), userAfterMap.getLogin());
        assertEquals(userDto.getPassword(), userAfterMap.getPassword());
    }

    @Test
    public void should_mapToUserDtoList() {
        // given
        User user = new User(1L, "test_user", "test_password");
        List<User> users = Collections.singletonList(user);

        // when
        List<UserDto> usersAfterMap = mapper.mapToUserDtoList(users);

        // then
        usersAfterMap.forEach(userDto1 -> {
            assertEquals(userDto1.getId(), users.get(0).getId());
            assertEquals(userDto1.getLogin(), users.get(0).getLogin());
            assertEquals(userDto1.getPassword(), users.get(0).getPassword());
        });
    }
}
