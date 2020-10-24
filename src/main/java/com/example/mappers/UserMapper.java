package com.example.mappers;

import com.example.dto.UpdateUserDto;
import com.example.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity(UpdateUserDto dto);

    UpdateUserDto toDto(User entity);
}
