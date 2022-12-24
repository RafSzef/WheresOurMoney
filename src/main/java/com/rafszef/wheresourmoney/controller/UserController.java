package com.rafszef.wheresourmoney.controller;

import com.rafszef.wheresourmoney.model.dto.user.CreateUserDto;
import com.rafszef.wheresourmoney.model.dto.user.UserDto;
import com.rafszef.wheresourmoney.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/find")
    public Set<UserDto> findUserByUsername(@RequestParam String username) {
        return userService.findUserByUsername(username);
    }

    @PostMapping("/add")
    public UserDto createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }

    @PostMapping("/changePassword")
    public UserDto changePassword(@RequestBody UserDto userDto) {
        return userService.changePassword(userDto);
    }
}
