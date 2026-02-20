package com.betterbudget.budget.api.controller;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.TransactionApi;
import org.openapitools.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TransactionController implements TransactionApi {
    @Override
    public ResponseEntity<Transaction> createTransaction(@Nullable Transaction transaction) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteTransactionById(Long transactionId) {
        return null;
    }

    @Override
    public ResponseEntity<Transaction> getTransactionById(Long transactionId) {
        return null;
    }

    @Override
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(Long userId, @Nullable LocalDate startDate, @Nullable LocalDate endDate) {
        return null;
    }


    @Override
    public ResponseEntity<Transaction> updateTransaction(@Nullable Transaction transaction) {
        return null;
    }
}
