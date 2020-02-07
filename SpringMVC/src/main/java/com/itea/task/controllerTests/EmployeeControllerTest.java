package com.itea.task.controllerTests;

import com.itea.task.configs.DataConfig;
import com.itea.task.controllers.EmployeeController;
import com.itea.task.dtos.EmployeeDto;
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
public class EmployeeControllerTest {

    @Autowired
    private EmployeeController controller;

    private EmployeeDto employee;

    @Test
    public void getEmployeeShouldWorkCorrectly() {
        employee = new EmployeeDto(1L, "getEmployeeTest", 11, null);
        controller.addEmployee(employee);
        assertEquals(OK, controller.getEmployee(1L).getStatusCode());
    }

    @Test
    public void getEmployeesShouldWorkCorrectly() {
        employee = new EmployeeDto(2L, "getEmployeesTest", 22, null);
        controller.addEmployee(employee);
        List<EmployeeDto> employees = controller.getEmployees();
        assertNotNull(employees.get(0));
    }

    @Test
    public void addEmployeeShouldWorkCorrectly() {
        employee = new EmployeeDto(3L, "addEmployeeTest", 33, null);
        assertEquals(OK, controller.addEmployee(employee).getStatusCode());
    }

    @Test
    public void deleteEmployeeShouldWorkCorrectly() {
        employee = new EmployeeDto(4L, "deleteEmployeeTest", 44, null);
        controller.addEmployee(employee);
        assertEquals(OK, controller.deleteEmployee(4L).getStatusCode());
    }

    @Test
    public void updateEmployeeShouldWorkCorrectly() {
        employee = new EmployeeDto(5L, "updateEmployeeTest", 55, null);
        controller.addEmployee(employee);
        assertEquals(OK, controller.updateEmployee(6L, employee).getStatusCode());
    }
}
