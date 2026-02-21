package com.betterbudget.budget.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionItemDto {
    private Long transactionItemId;
    private String category;
    private Double amount;
    private TransactionDto transaction;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
