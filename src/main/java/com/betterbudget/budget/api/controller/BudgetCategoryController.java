package com.betterbudget.budget.api.controller;

import com.betterbudget.budget.api.advice.BetterBudgetApiException;
import com.betterbudget.budget.service.BudgetCategoryService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.BudgetCategoryApi;
import org.openapitools.model.BudgetCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BudgetCategoryController implements BudgetCategoryApi {
    private final BudgetCategoryService budgetCategoryService;

    @Override
    @PostMapping("/budget-category")
    public ResponseEntity<BudgetCategory> createBudgetCategory(BudgetCategory budgetCategory) {
        if(budgetCategory.getBudgetCategoryId() != null) {
            throw new BetterBudgetApiException("Budget category id must be null on creation", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(budgetCategoryService.saveBudgetCategory(budgetCategory), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/budget-category/{userId}")
    public ResponseEntity<List<BudgetCategory>> getBudgetCategoriesByUserId(Long userId) {
        return new ResponseEntity<>(budgetCategoryService.getBudgetCategoriesByUser(userId), HttpStatus.OK);
    }

    @Override
    @PutMapping("/budget-category")
    public ResponseEntity<BudgetCategory> updateBudgetCategory(BudgetCategory budgetCategory) {
        if(budgetCategory.getBudgetCategoryId() == null) {
            throw new BetterBudgetApiException("Budget category id must not be null on update", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(budgetCategoryService.saveBudgetCategory(budgetCategory), HttpStatus.OK);
    }

    @Override
    @PatchMapping("/budget-category/{budgetCategoryId}/{status}")
    public ResponseEntity<Void> updateBudgetCategoryStatus(Long budgetCategoryId, Boolean status) {
        budgetCategoryService.updateBudgetCategoryStatus(budgetCategoryId, status);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
