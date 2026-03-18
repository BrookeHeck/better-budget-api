package com.betterbudget.budget.api.controller;

import com.betterbudget.budget.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.AccountApi;
import org.openapitools.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AccountController implements AccountApi {
    private final AccountService accountService;

    @Override
    @PostMapping("/account")
    public ResponseEntity<Account> createAccount(@Nullable Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/account/{accountId}")
    public ResponseEntity<Void> deleteAccount(Long accountId) {
        accountService.deleteAccountById(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/account/{accountId}")
    public ResponseEntity<Account> getAccount(Long accountId) {
        return new ResponseEntity<>(accountService.getAccountById(accountId), HttpStatus.OK);
    }

    @Override
    @GetMapping("/account/user/{userId}")
    public ResponseEntity<List<Account>> getUserAccounts(Long userId) {
        return new ResponseEntity<>(accountService.getAccountsByUserId(userId), HttpStatus.OK);
    }

    @Override
    @PutMapping("/account")
    public ResponseEntity<Account> updateAccount(@Nullable Account account) {
        return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
    }
}
