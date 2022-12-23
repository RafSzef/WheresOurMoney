package com.rafszef.wheresourmoney.model.dto.user;

import com.rafszef.wheresourmoney.model.entity.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private List<Role> roles;

    private boolean isAdmin;

}
