package com.betterbudget.budget.api.controller;

import lombok.RequiredArgsConstructor;
import org.openapitools.api.RecurringPaymentsApi;
import org.openapitools.model.RecurringPayment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RecurringPaymentController implements RecurringPaymentsApi {
    @Override
    @PostMapping("/recurring-payment")
    public ResponseEntity<RecurringPayment> createRecurringPayment(RecurringPayment recurringPayment) {
        return null;
    }

    @Override
    @DeleteMapping("/recurring-payment/{recurringPaymentId}")
    public ResponseEntity<Void> deleteRecurringPayment(Long recurringPaymentId) {
        return null;
    }

    @Override
    @GetMapping("/recurring-payment/{userId}")
    public ResponseEntity<List<RecurringPayment>> getRecurringPaymentsByUserId(Long userId) {
        return null;
    }

    @Override
    @PutMapping("/recurring-payment")
    public ResponseEntity<RecurringPayment> updateRecurringPayment(RecurringPayment recurringPayment) {
        return null;
    }
}
