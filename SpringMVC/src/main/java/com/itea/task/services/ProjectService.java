package com.itea.task.services;

import com.itea.task.entities.ProjectEntity;

import java.util.List;

public interface ProjectService {

    ProjectEntity add(ProjectEntity project);

    Long delete(Long id);

    ProjectEntity get(Long id);

    ProjectEntity update(Long id, ProjectEntity project);

    List<ProjectEntity> findAll();
}
