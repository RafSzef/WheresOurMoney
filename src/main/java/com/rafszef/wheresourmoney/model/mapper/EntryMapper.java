package com.rafszef.wheresourmoney.model.mapper;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.dto.entry.CreateEntryDto;
import com.rafszef.wheresourmoney.model.dto.entry.EntryDto;
import com.rafszef.wheresourmoney.model.entity.Entry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntryMapper {

    private final CategoryMapper categoryMapper;

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

    public Entry toNewEntity(CreateEntryDto createEntryDto) {
        return Entry.builder()
                .amount(createEntryDto.getAmount())
                .category(categoryMapper.toNewEntity(createEntryDto.getCategory()))
                .description(createEntryDto.getDescription())
                .timestamp(createEntryDto.getTimestamp())
                .user(createEntryDto.getUser())
                .build();
    }

    public Entry toEntity(EntryDto entryDto) {
        return Entry.builder()
                .amount(entryDto.getAmount())
                .category(entryDto.getCategory())
                .description(entryDto.getDescription())
                .timestamp(entryDto.getTimestamp())
                .user(entryDto.getUser())
                .build();
    }

}
