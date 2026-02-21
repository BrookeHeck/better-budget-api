package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.TransactionItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionItemRepository extends JpaRepository<TransactionItemEntity, Long> {
    @Query("""
        select item from TransactionItemEntity item where item.transaction.transactionId = :TRANSACTION_ID
    """)
    List<TransactionItemEntity> getTransactionItemsByTransactionId(@Param("TRANSACTION_ID") long transactionId);
}
