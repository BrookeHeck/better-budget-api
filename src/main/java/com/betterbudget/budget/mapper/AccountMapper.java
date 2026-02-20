package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.AccountEntity;
import com.betterbudget.budget.model.AccountDto;
import org.mapstruct.Mapper;
import org.openapitools.model.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto entityToDto(AccountEntity accountEntity);
    AccountEntity dtoToEntity(AccountDto accountDto);
    AccountDto apiModelToDtoModel(Account account);
    Account dtoModelToApiModel(AccountDto accountDto);
}
