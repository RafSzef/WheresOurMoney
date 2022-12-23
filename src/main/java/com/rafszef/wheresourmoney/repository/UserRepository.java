package com.rafszef.wheresourmoney.repository;

import com.rafszef.wheresourmoney.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
