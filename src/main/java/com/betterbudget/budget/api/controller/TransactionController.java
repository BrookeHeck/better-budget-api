package com.betterbudget.budget.api.controller;

import com.betterbudget.budget.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.TransactionApi;
import org.openapitools.model.Transaction;
import org.openapitools.model.TransactionTransfer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TransactionController implements TransactionApi {
    private final TransactionService transactionService;

    @Override
    @PostMapping("/transaction")
    public ResponseEntity<Transaction> createTransaction(@Nullable Transaction transaction) {
        return new ResponseEntity<>(transactionService.createPaymentOrDepositTransaction(transaction), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/transaction/{transactionId}")
    public ResponseEntity<Void> deleteTransactionById(Long transactionId) {
        transactionService.deleteTransactionById(transactionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(Long transactionId) {
        return new ResponseEntity<>(transactionService.getTransactionById(transactionId), HttpStatus.OK);
    }

    @Override
    @GetMapping("/transaction/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsByUserId(
            Long userId,
            @Nullable LocalDate startDate,
            @Nullable LocalDate endDate) {
        return new ResponseEntity<>(
                transactionService.getTransactionsByUserId(userId, startDate, endDate),
                HttpStatus.OK);
    }

    @Override
    @PutMapping("/transaction")
    public ResponseEntity<Transaction> updateTransaction(@Nullable Transaction transaction) {
        return new ResponseEntity<>(transactionService.updateTransaction(transaction), HttpStatus.OK);
    }

    @Override
    @PostMapping("/transaction/transfer")
    public ResponseEntity<TransactionTransfer> transactionTransfer(TransactionTransfer transactionTransfer) {
        return new ResponseEntity<>(transactionService.createTransferTransaction(transactionTransfer), HttpStatus.CREATED);
    }
}
