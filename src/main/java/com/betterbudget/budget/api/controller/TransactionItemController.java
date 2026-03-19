package com.betterbudget.budget.api.controller;

import com.betterbudget.budget.service.TransactionItemService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.TransactionItemApi;
import org.openapitools.model.TransactionItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TransactionItemController implements TransactionItemApi {
    private final TransactionItemService transactionItemService;

    @Override
    public ResponseEntity<TransactionItem> createTransactionItem(@Nullable TransactionItem transactionItem) {
        return new ResponseEntity<>(transactionItemService.createTransactionItem(transactionItem), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteTransactionItem(Long transactionItemId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TransactionItem>> getTransactionItemsByTransactionId(Long transactionId) {
        return new ResponseEntity<>(transactionItemService.getTransactionItemsByTransactionId(transactionId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TransactionItem> updateTransactionItem(@Nullable TransactionItem transactionItem) {
        return new ResponseEntity<>(transactionItemService.updateTransactionItem(transactionItem), HttpStatus.OK)       ;
    }
}
