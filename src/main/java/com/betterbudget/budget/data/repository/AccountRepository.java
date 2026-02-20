package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    @Query("""
        select a from AccountEntity a where a.user.userId = :USER_ID
    """)
    List<AccountEntity> findAllByUserId(@Param("USER_ID") long userId);
}
