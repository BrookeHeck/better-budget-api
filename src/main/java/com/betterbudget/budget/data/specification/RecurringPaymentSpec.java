package com.betterbudget.budget.data.specification;

import com.betterbudget.budget.data.entity_model.RecurringPaymentEntity;
import org.springframework.data.jpa.domain.PredicateSpecification;

import java.time.LocalDate;

public class RecurringPaymentSpec {
    public static PredicateSpecification<RecurringPaymentEntity> hasPastPayment() {
        return ((from, criteriaBuilder) ->
                criteriaBuilder.lessThan(from.get("nextPaymentDate"), LocalDate.now()));
    }
}
