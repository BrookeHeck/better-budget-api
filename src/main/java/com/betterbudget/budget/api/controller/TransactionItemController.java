package com.betterbudget.budget.api.controller;

import com.betterbudget.budget.service.TransactionItemService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.openapitools.api.TransactionItemApi;
import org.openapitools.model.TransactionItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TransactionItemController implements TransactionItemApi {
    private final TransactionItemService transactionItemService;

    @Override
    @PostMapping("/transaction-item")
    public ResponseEntity<TransactionItem> createTransactionItem(@Nullable TransactionItem transactionItem) {
        return new ResponseEntity<>(transactionItemService.createTransactionItem(transactionItem), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/transaction-item/{transactionItemId}")
    public ResponseEntity<Void> deleteTransactionItem(Long transactionItemId) {
        transactionItemService.deleteTransactionItemById(transactionItemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/transaction-item/{transactionId}")
    public ResponseEntity<List<TransactionItem>> getTransactionItemsByTransactionId(Long transactionId) {
        return new ResponseEntity<>(
                transactionItemService.getTransactionItemsByTransactionId(transactionId), HttpStatus.OK);
    }

    @Override
    @GetMapping("/transaction-item/budget/{budgetCategoryId}")
    public ResponseEntity<List<TransactionItem>> getTransactionItemsForBudgetCategory(Long budgetCategoryId, LocalDate date) {
        return new ResponseEntity<>(
                transactionItemService.getBudgetCategoryTransactionItems(budgetCategoryId, date), HttpStatus.OK
        );
    }


    @Override
    @PutMapping("/transaction-item")
    public ResponseEntity<TransactionItem> updateTransactionItem(@Nullable TransactionItem transactionItem) {
        return new ResponseEntity<>(transactionItemService.updateTransactionItem(transactionItem), HttpStatus.OK)       ;
    }
}
