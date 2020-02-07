package com.itea.task.controllers;

import com.itea.task.dtos.ProjectDto;
import com.itea.task.entities.ProjectEntity;
import com.itea.task.mappers.ProjectMapper;
import com.itea.task.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class ProjectController {

    @Autowired
    private ProjectService service;

    @Autowired
    private ProjectMapper mapper;

    private static final String NOT_FOUND_MESSAGE = "No project found ID: ";

    @GetMapping("/projects")
    public List<ProjectDto> getProjects() {
        List<ProjectEntity> entities = service.findAll();
        List<ProjectDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapper.toDto(e)));
        return dtos;
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<?> getProject(@PathVariable("id") Long id) {
        return isNull(service.get(id)) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(mapper.toDto(service.get(id)), OK);
    }

    @PostMapping("/projects")
    public ResponseEntity<?> addProject(@RequestBody ProjectDto project) {
        service.add(mapper.toEntity(project));
        return new ResponseEntity<>(project, OK);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id) {
        return isNull(service.delete(id)) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(id, OK);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<?> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDto project) {
        project = mapper.toDto(service.update(id, mapper.toEntity(project)));
        return isNull(project) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(project, OK);
    }
}
