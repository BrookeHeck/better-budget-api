package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.BudgetCategoryEntity;
import com.betterbudget.budget.model.BudgetCategoryDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.BudgetCategory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BudgetCategoryMapper {
    BudgetCategoryDto entityToDto(BudgetCategoryEntity entity);

    BudgetCategoryEntity dtoToEntity(BudgetCategoryDto dto);

    @Mapping(source = "user.userId", target = "userId")
    BudgetCategory dtoToApiModel(BudgetCategoryDto dto);

    @Mapping(source = "userId", target = "user.userId")
    BudgetCategoryDto apiModelToDto(BudgetCategory apiModel);

    @Mapping(source = "user.userId", target = "userId")
    BudgetCategory entityToApiModel(BudgetCategoryEntity entity);

    @Mapping(source = "userId", target = "user.userId")
    BudgetCategoryEntity apiModelToEntity(BudgetCategory apiModel);

    @IterableMapping
    List<BudgetCategory> entityListToApiModelList(List<BudgetCategoryEntity> entities);
}
