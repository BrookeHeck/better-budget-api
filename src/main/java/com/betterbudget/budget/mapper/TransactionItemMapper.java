package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.TransactionItemEntity;
import com.betterbudget.budget.model.TransactionItemDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.openapitools.model.TransactionItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionItemMapper {
    TransactionItemDto entityToDto(TransactionItemEntity transactionEntity);

    TransactionItem dtoToEntity(TransactionItemDto transactionItemDto);

    @Mapping(target = "transactionId", source = "transaction.transactionId")
    TransactionItem entityModelToApiModel(TransactionItemEntity transactionEntity);

    @Mapping(target = "transaction.transactionId", source = "transactionId")
    TransactionItemEntity apiModelToEntity(TransactionItem transactionItem);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    List<TransactionItem> entityListToApiModelList(List<TransactionItemEntity> transactions);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    List<TransactionItemEntity> apiModelListToEntityList(List<TransactionItem> transactions);
}
