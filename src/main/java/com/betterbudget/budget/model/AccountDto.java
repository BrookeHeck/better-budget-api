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
public class AccountDto {
    private Long accountId;
    private String name;
    private Double balance;
    private String type;
    private UserDto user;
}
