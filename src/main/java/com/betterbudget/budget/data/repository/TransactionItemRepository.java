package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.TransactionItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionItemRepository extends JpaRepository<TransactionItemEntity, Long> {
    @Query("""
        select item from TransactionItemEntity item where item.transaction.transactionId = :transactionId
    """)
    List<TransactionItemEntity> getTransactionItemsByTransactionId(@Param("transactionId") long transactionId);

    @Query("""
        select i from TransactionItemEntity i where i.transaction.category.budgetCategoryId = :budgetCategoryId
            and i.transaction.dateOfTransaction between :start and :end
    """)
    List<TransactionItemEntity> getBudgetCategoryTransactionItems(
            @Param("budgetCategoryId") long budgetCategoryId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end);
}
