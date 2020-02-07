package com.itea.task.mappers;

import com.itea.task.dtos.ProjectDto;
import com.itea.task.entities.ProjectEntity;

public interface ProjectMapper {

    ProjectEntity toEntity(ProjectDto dto);

    ProjectDto toDto(ProjectEntity entity);
}
