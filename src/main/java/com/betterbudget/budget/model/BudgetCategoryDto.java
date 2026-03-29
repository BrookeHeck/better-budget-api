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
public class BudgetCategoryDto {
    private Long budgetCategoryId;
    private String name;
    private Double budget;
    private UserDto user;
    private boolean active;
}
