package com.itea.task.services.impls;

import com.itea.task.entities.ProjectEntity;
import com.itea.task.repositories.ProjectRepository;
import com.itea.task.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;

    @Override
    public ProjectEntity add(ProjectEntity project) {
        return repository.saveAndFlush(project);
    }

    @Override
    public Long delete(Long id) {
        if (!isNull(get(id))) {
            repository.deleteById(id);
            return id;
        }
        return null;
    }

    @Override
    public ProjectEntity get(Long id) {
        return repository.getOne(id);
    }

    @Override
    public ProjectEntity update(Long id, ProjectEntity project) {
        if (!isNull(get(id))) {
            project.setId(repository.getOne(id).getId());
            repository.deleteById(id);
            repository.saveAndFlush(project);
            return project;
        }
        return null;
    }

    @Override
    public List<ProjectEntity> findAll() {
        return repository.findAll();
    }

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void destroy() {
    }
}
