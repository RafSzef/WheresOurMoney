package com.rafszef.wheresourmoney.service.entry;

import com.rafszef.wheresourmoney.model.dto.entry.CreateEntryDto;
import com.rafszef.wheresourmoney.model.dto.entry.EntryDto;
import com.rafszef.wheresourmoney.model.dto.user.UserDto;

import java.math.BigDecimal;
import java.util.List;

public interface EntryService {

    List<EntryDto> getAllEntries();

    EntryDto createEntry(CreateEntryDto createEntryDto);

    EntryDto changeEntry(EntryDto entryDto);

    void removeEntry(EntryDto entryDto);

    List<EntryDto> findEntriesByUser(String username);

    List<EntryDto> findAllIncomes();

    List<EntryDto> findAllOutcomes();

    List<EntryDto> findEntriesWithAmountGreaterThan(BigDecimal amount);

    List<EntryDto> findEntriesWithAmountLessThan(BigDecimal amount);

    List<EntryDto> findEntriesWithAmountBetween(BigDecimal min, BigDecimal max);

}
