package com.rafszef.wheresourmoney.service.entry;

import com.rafszef.wheresourmoney.model.dto.entry.CreateEntryDto;
import com.rafszef.wheresourmoney.model.dto.entry.EntryDto;
import com.rafszef.wheresourmoney.model.dto.user.UserDto;
import com.rafszef.wheresourmoney.model.entity.Entry;
import com.rafszef.wheresourmoney.model.entity.User;
import com.rafszef.wheresourmoney.model.mapper.EntryMapper;
import com.rafszef.wheresourmoney.repository.EntryRepository;
import com.rafszef.wheresourmoney.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService {

    private final EntryRepository entryRepository;
    private final UserRepository userRepository;
    private final EntryMapper entryMapper;

    @Override
    public List<EntryDto> getAllEntries() {
        return entryRepository.findAll().stream()
                .map(entryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EntryDto createEntry(CreateEntryDto createEntryDto) {
        Entry entry = entryMapper.toNewEntity(createEntryDto);
        entry.setTimestamp(LocalDateTime.now());
        var user = userRepository.findUsersByUsername(createEntryDto.getUser().getUsername());
        if (user.isPresent()) {
            entry.setUser(user.get());
        } else throw new EntityNotFoundException("No user found");

        return entryMapper.toDto(entryRepository.save(entry));
    }

    @Override
    public EntryDto changeEntry(EntryDto entryDto) {
        var entry = entryRepository.findEntriesById(entryDto.getId());
        if (entry.isPresent()) {
            entry.map(e -> {
                e.setUser(entryDto.getUser());
                e.setTimestamp(entryDto.getTimestamp());
                e.setAmount(entryDto.getAmount());
                e.setCategory(entryDto.getCategory());
                e.setDescription(entryDto.getDescription());
                return entryMapper.toDto(e);
            });
        } else {
            return entryMapper.toDto(entryRepository.save(entryMapper.toEntity(entryDto)));
        }
        return entryDto;
    }

    @Override
    public void removeEntry(EntryDto entryDto) {
        var entry = entryRepository.findEntriesById(entryDto.getId());
        if (entry.isPresent()) {
            entryRepository.deleteById(entry.get().getId());
        }else throw new EntityNotFoundException("No entry found");
        
    }

    @Override
    public List<EntryDto> findEntriesByUser(String username) {
        return entryRepository.findEntriesByUser_Username(username).stream()
                .map(entryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EntryDto> findAllIncomes() {

        return entryRepository.findEntriesByAmountGreaterThan(BigDecimal.ZERO).stream()
                .map(entryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EntryDto> findAllOutcomes() {
        return entryRepository.findEntriesByAmountLessThan(BigDecimal.ZERO).stream()
                .map(entryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EntryDto> findEntriesWithAmountGreaterThan(BigDecimal amount) {
        return entryRepository.findEntriesByAmountGreaterThan(amount).stream()
                .map(entryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EntryDto> findEntriesWithAmountLessThan(BigDecimal amount) {
        return entryRepository.findEntriesByAmountLessThan(amount).stream()
                .map(entryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EntryDto> findEntriesWithAmountBetween(BigDecimal min, BigDecimal max) {
        return entryRepository.findEntriesByAmountGreaterThanAndAmountLessThan(min, max).stream()
                .map(entryMapper::toDto)
                .collect(Collectors.toList());
    }
}
