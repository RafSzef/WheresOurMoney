package com.rafszef.wheresourmoney.repository;

import com.rafszef.wheresourmoney.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
