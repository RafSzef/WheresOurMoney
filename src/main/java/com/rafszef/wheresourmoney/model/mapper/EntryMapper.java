package com.rafszef.wheresourmoney.model.mapper;

import com.rafszef.wheresourmoney.model.dto.entry.EntryDto;
import com.rafszef.wheresourmoney.model.entity.Entry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntryMapper {

    public EntryDto toDto(Entry entry) {
        return EntryDto.builder()
                .id(entry.getId())
                .amount(entry.getAmount())
                .category(entry.getCategory())
                .description(entry.getDescription())
                .timestamp(entry.getTimestamp())
                .user(entry.getUser())
                .build();
    }


    public Entry toNewEntity(EntryDto entryDto) {
        return Entry.builder()
                .id(entryDto.getId())
                .amount(entryDto.getAmount())
                .category(entryDto.getCategory())
                .description(entryDto.getDescription())
                .timestamp(entryDto.getTimestamp())
                .user(entryDto.getUser())
                .build();
    }
}
