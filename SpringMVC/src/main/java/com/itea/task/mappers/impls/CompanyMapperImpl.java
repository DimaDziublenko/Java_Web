package com.itea.task.mappers.impls;

import com.itea.task.dtos.CompanyDto;
import com.itea.task.entities.CompanyEntity;
import com.itea.task.mappers.CompanyMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Autowired
    private ModelMapper mapper;

    @Override
    public CompanyEntity toEntity(CompanyDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, CompanyEntity.class);
    }

    @Override
    public CompanyDto toDto(CompanyEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, CompanyDto.class);
    }
}
