package com.rafszef.wheresourmoney.controller;

import com.rafszef.wheresourmoney.model.dto.account.AccountDto;
import com.rafszef.wheresourmoney.model.dto.account.CreateAccountDto;
import com.rafszef.wheresourmoney.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/all")
    public List<AccountDto> getAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/create")
    public AccountDto createAccount (@RequestBody CreateAccountDto createAccountDto) {
        return accountService.createAccount(createAccountDto);
    }
}
