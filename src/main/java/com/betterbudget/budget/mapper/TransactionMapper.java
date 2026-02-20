package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.TransactionEntity;
import com.betterbudget.budget.model.TransactionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDto entityToDto(TransactionEntity transactionEntity);
    TransactionEntity dtoToEntity(TransactionDto transactionDto);
}
