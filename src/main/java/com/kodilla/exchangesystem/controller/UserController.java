package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.UserDto;
import com.kodilla.exchangesystem.exception.UserNotFoundException;
import com.kodilla.exchangesystem.mapper.UserMapper;
import com.kodilla.exchangesystem.repository.UserRepository;
import com.kodilla.exchangesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @Autowired
    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UserDto> getUsers() {
        return mapper.mapToUserDtoList(service.getUsers());
    }

    @GetMapping(params = "userId")
    public UserDto getUser(@RequestParam Long userId) throws UserNotFoundException {
        return mapper.mapToUserDto(service.getUser(userId));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return mapper.mapToUserDto(service.addUser(mapper.mapToUser(userDto)));
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return mapper.mapToUserDto(service.addUser(mapper.mapToUser(userDto)));
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long userId) {
        service.deleteUser(userId);
    }
}
