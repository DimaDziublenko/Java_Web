package com.itea.task.mapper;

import com.itea.task.dto.UserDto;
import com.itea.task.entities.UserEntity;

public interface UserMapper {

    UserEntity toEntity(UserDto dto);

    UserDto toDto(UserEntity entity);
}
