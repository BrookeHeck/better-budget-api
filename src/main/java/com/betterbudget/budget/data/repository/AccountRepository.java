package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
