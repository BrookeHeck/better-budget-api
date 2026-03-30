package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.BudgetCategoryEntity;
import com.betterbudget.budget.data.entity_model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BudgetCategoryRepository extends JpaRepository<BudgetCategoryEntity, Long> {
    @Query("""
        select b from BudgetCategoryEntity b where b.user.userId=:user_id
        """)
    List<BudgetCategoryEntity> findBudgetCategoryEntitiesByUserId(@Param("user_id") long userId);

    @Modifying
    @Query("""
        update BudgetCategoryEntity b set b.active = :status where b.budgetCategoryId = :id
        """)
    void updateBudgetCategoryStatus(@Param("id") long categoryId, @Param("status") boolean status);
}
