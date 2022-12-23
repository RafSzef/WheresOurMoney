package com.rafszef.wheresourmoney.service.account;

import com.rafszef.wheresourmoney.model.dto.account.AccountDto;
import com.rafszef.wheresourmoney.model.dto.account.CreateAccountDto;
import com.rafszef.wheresourmoney.model.entity.Account;
import com.rafszef.wheresourmoney.model.mapper.AccountMapper;
import com.rafszef.wheresourmoney.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto createAccount(CreateAccountDto createAccountDto) {
        Account account = accountMapper.toNewEntity(createAccountDto);
        return accountMapper.toNewDto(accountRepository.save(account));
    }
}
