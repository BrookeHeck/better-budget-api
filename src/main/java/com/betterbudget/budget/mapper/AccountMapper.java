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

    @Mapping(target = "user.userId", source = "userId")
    @Mapping(target = "type", source = "accountType")
    AccountDto apiModelToDtoModel(Account account);

    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "accountType", source = "type")
    Account dtoModelToApiModel(AccountDto accountDto);

    @Mapping(target = "user.userId", source = "userId")
    @Mapping(target = "type", source = "accountType")
    AccountEntity apiModelToEntity(Account account);

    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "accountType", source = "type")
    Account entityToApiModel(AccountEntity accountEntity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    List<Account> entityListToApiModelList(List<AccountEntity> accounts);
}
