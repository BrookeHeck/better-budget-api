package com.betterbudget.budget.data.repository;

import com.betterbudget.budget.data.entity_model.RecurringPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecurringPaymentRepository extends
        JpaRepository<RecurringPaymentEntity, Long>,
        JpaSpecificationExecutor<RecurringPaymentEntity>
    {
    @Query("""
        select r from RecurringPaymentEntity r where r.user.userId = :userId
            order by r.nextPaymentDate, r.paymentAmount desc
    """)
    List<RecurringPaymentEntity> getRecurringPaymentEntitiesByUserId(@Param("userId") long userId);
}
