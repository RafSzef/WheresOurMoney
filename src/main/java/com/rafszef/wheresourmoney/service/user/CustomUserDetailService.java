package com.rafszef.wheresourmoney.service.user;

import com.rafszef.wheresourmoney.model.CustomUserDetails;
import com.rafszef.wheresourmoney.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = userRepository.findUsersByUsername(username);
        if (user.isPresent()) {
            return new CustomUserDetails(user.get());
        } else throw new UsernameNotFoundException("User not Found " + username);

    }
}
