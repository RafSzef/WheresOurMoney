package com.rafszef.wheresourmoney.repository;

import com.rafszef.wheresourmoney.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUsersByUsername(String username);
}
