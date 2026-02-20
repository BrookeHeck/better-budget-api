package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.TransactionEntity;
import com.betterbudget.budget.model.TransactionItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionItemMapper {
    TransactionItemDto entityToDto(TransactionEntity transactionEntity);
    TransactionEntity dtoToEntity(TransactionItemDto transactionItemDto);
}
