package com.betterbudget.budget.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openapitools.model.RecurringPayment;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecurringPaymentDto {
    private Long recurringPaymentId;

    private RecurringPayment.PaymentIntervalEnum paymentInterval;

    private String name;

    private LocalDate nextPaymentDate;

    private Double paymentAmount;

    private Boolean notifications;

    private UserDto user;
}
