package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.BudgetCategoryEntity;
import com.betterbudget.budget.data.entity_model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BudgetCategoryRepository extends JpaRepository<BudgetCategoryEntity, Long> {
    List<BudgetCategoryEntity> findBudgetCategoryEntitiesByUser(UserEntity user);

    @Modifying
    @Query("""
        update BudgetCategoryEntity e set e.active = :status where e.budgetCategoryId = :id
        """)
    void updateBudgetCategoryStatus(@Param("id") long categoryId, @Param("status") boolean status);
}
