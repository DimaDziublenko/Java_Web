package com.itea.task.mappers.impls;

import com.itea.task.dtos.CarDto;
import com.itea.task.entities.CarEntity;
import com.itea.task.mappers.CarMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CarMapperImpl implements CarMapper {

    @Autowired
    private ModelMapper mapper;

    @Override
    public CarEntity toEntity(CarDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, CarEntity.class);
    }

    @Override
    public CarDto toDto(CarEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CarDto.class);
    }
}
