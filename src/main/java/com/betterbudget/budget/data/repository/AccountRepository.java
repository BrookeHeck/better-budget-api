package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}
