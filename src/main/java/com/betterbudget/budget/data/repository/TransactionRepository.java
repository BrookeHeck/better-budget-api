package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    @Query("""
        select t from TransactionEntity t
            where t.user.userId = :userId
            and (t.dateOfTransaction between :startDate and :endDate)
    """)
    List<TransactionEntity> findAllByUserId(
            @Param("userId") Long userId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}
