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
            where t.user.userId = :USER_ID
            and (t.dateOfTransaction > :START_DATE and t.dateOfTransaction < :END_DATE)
    """)
    List<TransactionEntity> findAllByUserId(
            @Param("USER_ID") Long userId,
            @Param("START_DATE") LocalDate startDate,
            @Param("END_DATE") LocalDate endDate);
}
