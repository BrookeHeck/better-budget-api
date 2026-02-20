package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
}
