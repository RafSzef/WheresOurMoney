package com.rafszef.wheresourmoney.model.mapper;

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

    public User toNewEntity(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(userDto.getPassword())
                .roles(userDto.getRoles())
                .isAdmin(userDto.isAdmin())
                .build();
    }
}
