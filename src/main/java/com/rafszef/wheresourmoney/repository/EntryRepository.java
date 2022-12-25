package com.rafszef.wheresourmoney.repository;

import com.rafszef.wheresourmoney.model.dto.entry.EntryDto;
import com.rafszef.wheresourmoney.model.dto.user.UserDto;
import com.rafszef.wheresourmoney.model.entity.Entry;
import com.rafszef.wheresourmoney.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

    Optional<Entry> findEntriesById(Long entryID);
    List<Entry> findEntriesByUser_Username(String username);
    List<Entry> findEntriesByAmountGreaterThan(BigDecimal amount);
    List<Entry> findEntriesByAmountLessThan(BigDecimal amount);
    List<Entry> findEntriesByAmountGreaterThanAndAmountLessThan(BigDecimal min, BigDecimal max);
}
