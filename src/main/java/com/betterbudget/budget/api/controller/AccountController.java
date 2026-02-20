package com.betterbudget.budget.api.controller;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.AccountApi;
import org.openapitools.model.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController implements AccountApi {

    @Override
    public ResponseEntity<Account> createAccount(@Nullable Account account) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAccount(Long accountId) {
        return null;
    }

    @Override
    public ResponseEntity<Account> getAccount(Long accountId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Account>> getUserAccounts(Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<Account> updateAccount(@Nullable Account account) {
        return null;
    }
}
