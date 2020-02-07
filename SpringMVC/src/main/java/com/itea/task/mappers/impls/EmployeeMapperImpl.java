package com.itea.task.mappers.impls;

import com.itea.task.dtos.EmployeeDto;
import com.itea.task.entities.EmployeeEntity;
import com.itea.task.mappers.EmployeeMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private ModelMapper mapper;

    @Override
    public EmployeeEntity toEntity(EmployeeDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, EmployeeEntity.class);
    }

    @Override
    public EmployeeDto toDto(EmployeeEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, EmployeeDto.class);
    }
}
