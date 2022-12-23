package com.rafszef.wheresourmoney.model.mapper;

import com.rafszef.wheresourmoney.model.dto.account.AccountDto;
import com.rafszef.wheresourmoney.model.dto.entry.EntryDto;
import com.rafszef.wheresourmoney.model.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AccountMapper {

    private final EntryMapper entryMapper;

    public AccountDto toDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .entries(account.getEntries().stream().map(entryMapper::toDto).collect(Collectors.toList()))
                .name(account.getName())
                .build();
    }

    public Account toNewEntity(AccountDto accountDto) {
        return Account.builder()
                .id(accountDto.getId())
                .entries(accountDto.getEntries().stream().map(entryMapper::toNewEntity).collect(Collectors.toList()))
                .name(accountDto.getName())
                .build();
    }
}
