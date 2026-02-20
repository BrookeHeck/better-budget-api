package com.betterbudget.budget.api.controller;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.TransactionItemApi;
import org.openapitools.model.TransactionItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TransactionItemController implements TransactionItemApi {
    @Override
    public ResponseEntity<TransactionItem> createTransactionItem(@Nullable TransactionItem transactionItem) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteTransactionItem(Long transactionItemId) {
        return null;
    }

    @Override
    public ResponseEntity<List<TransactionItem>> getTransactionItemsByTransactionId(Long transactionId) {
        return null;
    }

    @Override
    public ResponseEntity<TransactionItem> updateTransactionItem(@Nullable TransactionItem transactionItem) {
        return null;
    }
}
