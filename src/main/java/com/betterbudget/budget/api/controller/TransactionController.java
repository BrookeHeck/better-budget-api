package com.betterbudget.budget.api.controller;

import com.betterbudget.budget.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.TransactionApi;
import org.openapitools.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TransactionController implements TransactionApi {
    private final TransactionService transactionService;

    @Override
    public ResponseEntity<Transaction> createTransaction(@Nullable Transaction transaction) {
        return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteTransactionById(Long transactionId) {
        transactionService.deleteTransactionById(transactionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Transaction> getTransactionById(Long transactionId) {
        return new ResponseEntity<>(transactionService.getTransactionById(transactionId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(
            Long userId,
            @Nullable LocalDate startDate,
            @Nullable LocalDate endDate) {
        return new ResponseEntity<>(
                transactionService.getTransactionsByUserId(userId, startDate, endDate),
                HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Transaction> updateTransaction(@Nullable Transaction transaction) {
        return new ResponseEntity<>(transactionService.updateTransaction(transaction), HttpStatus.OK);
    }
}
