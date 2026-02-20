package com.betterbudget.budget.mapper;

import com.betterbudget.budget.data.entity_model.UserEntity;
import com.betterbudget.budget.model.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto entityToDto(UserEntity userEntity);
    UserEntity dtoToEntity(UserDto userDto);
}
