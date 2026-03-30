package com.betterbudget.budget.api.controller;

import lombok.RequiredArgsConstructor;
import org.openapitools.api.BudgetCategoryApi;
import org.openapitools.model.BudgetCategory;
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

    @Override
    @PostMapping("/budget-category")
    public ResponseEntity<BudgetCategory> createBudgetCategory(BudgetCategory budgetCategory) {
        return null;
    }

    @Override
    @GetMapping("/budget-category/{userId}")
    public ResponseEntity<List<BudgetCategory>> getBudgetCategoriesByUserId(Long userId) {
        return null;
    }

    @Override
    @PutMapping("/budget-category")
    public ResponseEntity<BudgetCategory> updateBudgetCategory(BudgetCategory budgetCategory) {
        return null;
    }

    @Override
    @PatchMapping("/budget-category/{budgetCategoryId}/{status}")
    public ResponseEntity<Void> updateBudgetCategoryStatus(Long budgetCategoryId, Boolean status) {
        return null;
    }
}
