package com.itea.task.mappers.impls;

import com.itea.task.dtos.ProjectDto;
import com.itea.task.entities.ProjectEntity;
import com.itea.task.mappers.ProjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Autowired
    private ModelMapper mapper;

    @Override
    public ProjectEntity toEntity(ProjectDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, ProjectEntity.class);
    }

    @Override
    public ProjectDto toDto(ProjectEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ProjectDto.class);
    }
}
