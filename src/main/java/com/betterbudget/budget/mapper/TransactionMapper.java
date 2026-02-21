package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.TransactionEntity;
import com.betterbudget.budget.model.TransactionDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.openapitools.model.Transaction;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    TransactionDto entityToDto(TransactionEntity transactionEntity);

    TransactionEntity dtoToEntity(TransactionDto transactionDto);

    TransactionDto apiModelToDto(Transaction transaction);

    Transaction dtoToApiModel(TransactionDto transactionDto);

    TransactionEntity apiModelToEntity(Transaction transaction);

    Transaction entityToApiModel(TransactionEntity transactionEntity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    List<Transaction> entityListToApiModelList(List<TransactionEntity> transactions);
}
