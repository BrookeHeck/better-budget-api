package com.betterbudget.budget.api.controller;

import com.betterbudget.budget.api.advice.BetterBudgetApiException;
import com.betterbudget.budget.service.RecurringPaymentService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.RecurringPaymentsApi;
import org.openapitools.model.RecurringPayment;
import org.springframework.http.HttpStatus;
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
    private final RecurringPaymentService recurringPaymentService;

    @Override
    @PostMapping("/recurring-payment")
    public ResponseEntity<RecurringPayment> createRecurringPayment(RecurringPayment recurringPayment) {
        if(recurringPayment.getRecurringPaymentId() != null) {
            throw new BetterBudgetApiException("Recurring payment id must be null on creation.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(recurringPaymentService.saveRecurringPayment(recurringPayment), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/recurring-payment/{recurringPaymentId}")
    public ResponseEntity<Void> deleteRecurringPayment(Long recurringPaymentId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/recurring-payment/{userId}")
    public ResponseEntity<List<RecurringPayment>> getRecurringPaymentsByUserId(Long userId) {
        return new ResponseEntity<>(recurringPaymentService.getRecurringPaymentsByUserId(userId), HttpStatus.OK);
    }

    @Override
    @PutMapping("/recurring-payment")
    public ResponseEntity<RecurringPayment> updateRecurringPayment(RecurringPayment recurringPayment) {
        if(recurringPayment.getRecurringPaymentId() == null) {
            throw new BetterBudgetApiException("Recurring payment id must not be null on update.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(recurringPaymentService.saveRecurringPayment(recurringPayment), HttpStatus.OK);
    }
}
