package com.betterbudget.budget.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private Long transactionId;
    private BudgetCategoryDto category;
    private Double amount;
    private String description;
    private AccountDto account;
    private UserDto user;
    private LocalDate dateOfTransaction;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
