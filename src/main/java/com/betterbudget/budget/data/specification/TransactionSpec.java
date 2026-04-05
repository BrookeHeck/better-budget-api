package com.betterbudget.budget.data.specification;

import com.betterbudget.budget.data.entity_model.TransactionEntity;
import org.springframework.data.jpa.domain.PredicateSpecification;

import java.time.LocalDateTime;

public class TransactionSpec {
    public static PredicateSpecification<TransactionEntity> hasAccountId(Long accountId) {
        return ((from, criteriaBuilder) -> {
            if(accountId == null) return null;
            return criteriaBuilder.equal(from.join("account").get("accountId"), accountId);
        });
    }

    public static PredicateSpecification<TransactionEntity> hasCategoryId(Long categoryId) {
        return ((from, criteriaBuilder) -> {
            if(categoryId == null) return null;
            return criteriaBuilder.equal(from.get("category").get("budgetCategoryId"), categoryId);
        });
    }

    public static PredicateSpecification<TransactionEntity> hasUserId(Long userId) {
        return ((from, criteriaBuilder) -> {
            if(userId == null) return null;
            return criteriaBuilder.equal(from.get("user").get("userId"), userId);
        });
    }

    public static PredicateSpecification<TransactionEntity> isBetweenDates(LocalDateTime start, LocalDateTime end) {
        return ((from, criteriaBuilder) -> {
            if(start == null || end == null) return null;
            return criteriaBuilder.between(from.get("dateOfTransaction"), start, end);
        });
    }
}
