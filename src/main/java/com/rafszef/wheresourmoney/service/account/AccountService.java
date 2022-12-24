package com.rafszef.wheresourmoney.service.account;

import com.rafszef.wheresourmoney.model.dto.account.AccountDto;
import com.rafszef.wheresourmoney.model.dto.account.CreateAccountDto;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAllAccounts();

    AccountDto createAccount(CreateAccountDto createAccountDto);
}
