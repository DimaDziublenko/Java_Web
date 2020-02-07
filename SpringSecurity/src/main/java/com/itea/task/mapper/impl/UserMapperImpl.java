package com.itea.task.mapper.impl;

import com.itea.task.dto.UserDto;
import com.itea.task.entities.UserEntity;
import com.itea.task.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Objects.isNull;

public class UserMapperImpl implements UserMapper {

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserEntity toEntity(UserDto dto) {
        return isNull(dto) ? null : mapper.map(dto, UserEntity.class);
    }

    @Override
    public UserDto toDto(UserEntity entity) {
        return isNull(entity) ? null : mapper.map(entity, UserDto.class);
    }
}
