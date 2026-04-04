package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransactionRepository
        extends JpaRepository<TransactionEntity, Long>,
        JpaSpecificationExecutor<TransactionEntity>
{}
