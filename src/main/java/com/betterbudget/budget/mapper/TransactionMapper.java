package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.TransactionEntity;
import com.betterbudget.budget.model.TransactionDto;
import org.mapstruct.Mapper;
import org.openapitools.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDto entityToDto(TransactionEntity transactionEntity);
    TransactionEntity dtoToEntity(TransactionDto transactionDto);
    TransactionDto apiModelToDto(Transaction transaction);
    Transaction dtoToApiModel(TransactionDto transactionDto);
}
