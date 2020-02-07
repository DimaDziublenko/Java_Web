package com.itea.task.controllerTests;

import com.itea.task.configs.DataConfig;
import com.itea.task.controllers.ProjectController;
import com.itea.task.dtos.ProjectDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpStatus.OK;


@DirtiesContext
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class ProjectControllerTest {

    @Autowired
    private ProjectController controller;

    private ProjectDto project;

    @Test
    public void getProjectShouldWorkCorrectly() {
        project = new ProjectDto(1L, "getProjectTest", 11.11F);
        controller.addProject(project);
        assertEquals(OK, controller.getProject(1L).getStatusCode());
    }

    @Test
    public void getProjectsShouldWorkCorrectly() {
        project = new ProjectDto(2L, "getProjectsTest", 22.22F);
        controller.addProject(project);
        List<ProjectDto> projects = controller.getProjects();
        assertNotNull(projects.get(0));
    }

    @Test
    public void addProjectShouldWorkCorrectly() {
        project = new ProjectDto(3L, "addProjectTest", 33.33F);
        assertEquals(OK, controller.addProject(project).getStatusCode());
    }

    @Test
    public void deleteProjectShouldWorkCorrectly() {
        project = new ProjectDto(4L, "deleteProjectTest", 44.44F);
        controller.addProject(project);
        assertEquals(OK, controller.deleteProject(4L).getStatusCode());
    }

    @Test
    public void updateProjectShouldWorkCorrectly() {
        project = new ProjectDto(5L, "updateProjectTest", 55.55F);
        controller.addProject(project);
        assertEquals(OK, controller.updateProject(6L, project).getStatusCode());
    }
}
