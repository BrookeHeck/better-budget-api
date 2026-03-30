package com.betterbudget.budget.service;

import com.betterbudget.budget.data.entity_model.BudgetCategoryEntity;
import com.betterbudget.budget.data.repository.BudgetCategoryRepository;
import com.betterbudget.budget.mapper.BudgetCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.BudgetCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetCategoryService {
    private final BudgetCategoryRepository budgetCategoryRepo;
    private final BudgetCategoryMapper mapper;

    public BudgetCategory saveBudgetCategory(BudgetCategory budgetCategory) {
        return mapper.entityToApiModel(budgetCategoryRepo.save(mapper.apiModelToEntity(budgetCategory)));
    }

    public List<BudgetCategory> getBudgetCategoriesByUser(long budgetCategoryId) {
        return mapper.entityListToApiModelList(budgetCategoryRepo.findBudgetCategoryEntitiesByUserId(budgetCategoryId));
    }

    public void updateBudgetCategoryStatus(long budgetCategoryId, boolean status) {
        budgetCategoryRepo.updateBudgetCategoryStatus(budgetCategoryId, status);
    }
}
