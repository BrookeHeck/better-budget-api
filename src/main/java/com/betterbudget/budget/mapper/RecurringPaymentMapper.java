package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.RecurringPaymentEntity;
import com.betterbudget.budget.model.RecurringPaymentDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.openapitools.model.RecurringPayment;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecurringPaymentMapper {
    RecurringPaymentEntity dtoToEntity(RecurringPaymentDto dto);

    RecurringPaymentDto entityToDto(RecurringPaymentEntity entity);

    @Mapping(source = "userId", target = "user.userId")
    RecurringPaymentDto apiModelToDto(RecurringPayment apiModel);

    @Mapping(source = "user.userId", target = "userId")
    RecurringPayment dtoToApiModel(RecurringPaymentDto dto);

    @Mapping(source = "userId", target = "user.userId")
    RecurringPaymentEntity apiModelToEntity(RecurringPayment apiModel);

    @Mapping(source = "user.userId", target = "userId")
    RecurringPayment entityToApiModel(RecurringPaymentEntity entity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    List<RecurringPayment> entityListToApiModel(List<RecurringPaymentEntity> entities);

}
