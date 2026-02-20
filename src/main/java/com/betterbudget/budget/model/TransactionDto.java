package com.betterbudget.budget.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDto {
    private Long transactionId;
    private String category;
    private Double amount;
    private String description;
    private AccountDto account;
    private UserDto user;
}
