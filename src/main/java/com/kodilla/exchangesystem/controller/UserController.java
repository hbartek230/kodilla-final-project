package com.kodilla.exchangesystem.controller;

import com.kodilla.exchangesystem.domain.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @GetMapping(params = "userId")
    public UserDto getUser(@RequestParam Long userId) {
        return new UserDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return new UserDto();
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto();
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long userId) {

    }
}
