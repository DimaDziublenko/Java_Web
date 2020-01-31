package com.itea.task.mappers;

import com.itea.task.dtos.CarDto;
import com.itea.task.entities.CarEntity;

public interface CarMapper {

    CarEntity toEntity(CarDto dto);

    CarDto toDto(CarEntity entity);
}
