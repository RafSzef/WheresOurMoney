package com.rafszef.wheresourmoney.service.user;

import com.rafszef.wheresourmoney.model.dto.user.CreateUserDto;
import com.rafszef.wheresourmoney.model.dto.user.UserDto;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto createUser(CreateUserDto createUserDto);

    UserDto changePassword(UserDto userDto);

    Set<UserDto> findUserByUsername(String username);

}