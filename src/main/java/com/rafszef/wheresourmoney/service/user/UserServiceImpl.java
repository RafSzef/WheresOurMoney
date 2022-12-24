package com.rafszef.wheresourmoney.service.user;

import com.rafszef.wheresourmoney.model.dto.user.CreateUserDto;
import com.rafszef.wheresourmoney.model.dto.user.UserDto;
import com.rafszef.wheresourmoney.model.entity.User;
import com.rafszef.wheresourmoney.model.mapper.UserMapper;
import com.rafszef.wheresourmoney.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        User user = userMapper.toNewEntity(createUserDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto changePassword(UserDto userDto) {
        var user = userRepository.findUsersByUsername(userDto.getUsername());
        if (user.isPresent()) {
            user.get().setPassword(userDto.getPassword());
        } else {
            throw new EntityNotFoundException("User not found");
        }
        return userDto;
    }

    @Override
    public Set<UserDto> findUserByUsername(String username) {
        Set<UserDto> users = userRepository.findUsersByUsername(username).stream()
                .map(userMapper::toDto)
                .collect(Collectors.toSet());
        if (users.isEmpty()) {
            throw new EntityNotFoundException("User with given username does not exists");
        } else return users;
    }
}
