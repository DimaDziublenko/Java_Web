package com.itea.task.mappers;

import com.itea.task.dtos.CompanyDto;
import com.itea.task.entities.CompanyEntity;

public interface CompanyMapper {

    CompanyEntity toEntity(CompanyDto dto);

    CompanyDto toDto(CompanyEntity entity);
}
