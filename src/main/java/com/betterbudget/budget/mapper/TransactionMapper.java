package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.TransactionEntity;
import com.betterbudget.budget.model.TransactionDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.openapitools.model.Transaction;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDto entityToDto(TransactionEntity transactionEntity);

    TransactionEntity dtoToEntity(TransactionDto transactionDto);

    @Mapping(target = "user.userId", source = "userId")
    @Mapping(target = "account.accountId", source = "accountId")
    @Mapping(target = "category.budgetCategoryId", source = "categoryId")
    TransactionDto apiModelToDto(Transaction transaction);

    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "accountId", source = "account.accountId")
    @Mapping(target = "categoryId", source = "category.budgetCategoryId")
    Transaction dtoToApiModel(TransactionDto transactionDto);

    @Mapping(target = "user.userId", source = "userId")
    @Mapping(target = "account.accountId", source = "accountId")
    @Mapping(target = "category.budgetCategoryId", source = "categoryId")
    TransactionEntity apiModelToEntity(Transaction transaction);

    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "accountId", source = "account.accountId")
    @Mapping(target = "categoryId", source = "category.budgetCategoryId")
    Transaction entityToApiModel(TransactionEntity transactionEntity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    List<Transaction> entityListToApiModelList(List<TransactionEntity> transactions);
}
