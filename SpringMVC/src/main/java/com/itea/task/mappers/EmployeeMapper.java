package com.itea.task.mappers;

import com.itea.task.dtos.EmployeeDto;
import com.itea.task.entities.EmployeeEntity;

public interface EmployeeMapper {

    EmployeeEntity toEntity(EmployeeDto dto);

    EmployeeDto toDto(EmployeeEntity entity);
}
