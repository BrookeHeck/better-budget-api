package com.betterbudget.budget.service;

import com.betterbudget.budget.data.repository.AccountRepository;
import com.betterbudget.budget.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepo;
    private final AccountMapper accountMapper;

    public List<Account> getAccountsByUserId(long userId) {
        return accountMapper.entityListToApiModelList(accountRepo.findAllByUserId(userId));
    }

    public Account getAccountById(long accountId) {
        return accountMapper.entityToApiModel(accountRepo.getReferenceById(accountId));
    }

    public void deleteAccountById(long accountId) {
        accountRepo.deleteById(accountId);
    }

    public Account createAccount(Account account) {
        return accountMapper.entityToApiModel(accountRepo.save(accountMapper.apiModelToEntity(account)));
    }

    public Account updateAccount(Account account) {
        return accountMapper.entityToApiModel(accountRepo.save(accountMapper.apiModelToEntity(account)));
    }

    public Account updateAccountBalance(long accountId, double amount) {
        Account account = getAccountById(accountId);
        account.setBalance(account.getBalance() + amount);
        return updateAccount(account);
    }
}
