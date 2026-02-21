package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.AccountEntity;
import com.betterbudget.budget.model.AccountDto;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.openapitools.model.Account;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto entityToDto(AccountEntity accountEntity);

    AccountEntity dtoToEntity(AccountDto accountDto);

    AccountDto apiModelToDtoModel(Account account);

    Account dtoModelToApiModel(AccountDto accountDto);

    AccountEntity apiModelToEntity(Account account);

    Account entityToApiModel(AccountEntity accountEntity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    List<Account> entityListToApiModelList(List<AccountEntity> accounts);
}
