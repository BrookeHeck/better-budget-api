package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.TransactionEntity;
import com.betterbudget.budget.model.TransactionItemDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.openapitools.model.TransactionItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionItemMapper {
    TransactionItemDto entityToDto(TransactionEntity transactionEntity);

    TransactionEntity dtoToEntity(TransactionItemDto transactionItemDto);

    TransactionItem entityModelToApiModel(TransactionEntity transactionEntity);

    TransactionEntity apiModelToEntity(TransactionItem transactionItem);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    List<TransactionItem> entityListToApiModelList(List<TransactionEntity> transactions);
}
