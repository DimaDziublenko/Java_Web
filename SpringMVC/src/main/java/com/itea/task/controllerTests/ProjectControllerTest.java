package com.itea.task.controllerTests;

import com.itea.task.controllers.ProjectController;
import com.itea.task.dtos.ProjectDto;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.OK;

public class ProjectControllerTest {

    @Autowired
    private static ProjectController controller;

    private static ProjectDto project;

    @BeforeClass
    public static void setUp() {
        project = new ProjectDto(1L, "test1", 111.1F);
        controller.addProject(project);
    }

    @Test
    public void getProjectsRequestShouldWorkCorrectly() {
        List<ProjectDto> dtos = controller.getProjects();
        assertEquals(project, dtos.get(0));
    }

    @Test
    public void getProjectRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(project, OK), controller.getProject(1L));
    }

    @Test
    public void addProjectRequestShouldWorkCorrectly() {
        controller.deleteProject(1L);
        assertEquals(new ResponseEntity<>(project, OK), controller.addProject(project));
    }

    @Test
    public void deleteProjectRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(1L, OK), controller.deleteProject(1L));
        controller.addProject(project);
    }

    @Test
    public void updateProjectRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(project, OK), controller.updateProject(1L, project));
    }
}
