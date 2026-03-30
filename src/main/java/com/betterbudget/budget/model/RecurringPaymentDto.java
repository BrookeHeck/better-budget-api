package com.betterbudget.budget.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecurringPaymentDto {
    private Long recurringPaymentId;

    private String paymentInterval;

    private String name;

    private LocalDate nextPaymentDate;

    private Boolean notifications;

    private UserDto user;
}
