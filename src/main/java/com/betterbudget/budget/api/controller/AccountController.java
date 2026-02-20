package com.betterbudget.budget.api.controller;

import com.betterbudget.budget.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.AccountApi;
import org.openapitools.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController implements AccountApi {
    private final AccountService accountService;

    @Override
    public ResponseEntity<Account> createAccount(@Nullable Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteAccount(Long accountId) {
        accountService.deleteAccountById(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Account> getAccount(Long accountId) {
        return new ResponseEntity<>(accountService.getAccountById(accountId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Account>> getUserAccounts(Long userId) {
        return new ResponseEntity<>(accountService.getAccountsByUserId(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Account> updateAccount(@Nullable Account account) {
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }
}
