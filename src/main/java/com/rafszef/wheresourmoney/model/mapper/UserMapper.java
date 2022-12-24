package com.rafszef.wheresourmoney.model.mapper;

import com.rafszef.wheresourmoney.model.dto.user.CreateUserDto;
import com.rafszef.wheresourmoney.model.dto.user.UserDto;
import com.rafszef.wheresourmoney.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .roles(user.getRoles())
                .isAdmin(user.isAdmin())
                .build();
    }

    public User toNewEntity(CreateUserDto createUserDto) {
        return User.builder()
                .username(createUserDto.getUsername())
                .firstName(createUserDto.getFirstName())
                .lastName(createUserDto.getLastName())
                .password(createUserDto.getPassword())
                .isAdmin(createUserDto.isAdmin())
                .build();
    }

    public User toEntity(UserDto userDto) {
        return User.builder()
                .isAdmin(userDto.isAdmin())
                .roles(userDto.getRoles())
                .username(userDto.getUsername())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(userDto.getPassword())
                .isAdmin(userDto.isAdmin())
                .build();
    }
}
