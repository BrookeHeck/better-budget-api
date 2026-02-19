package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.TransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionItemRepository extends JpaRepository<TransactionItem, Long> {
}
