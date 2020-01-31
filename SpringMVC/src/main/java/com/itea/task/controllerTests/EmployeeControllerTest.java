package com.itea.task.controllerTests;

import com.itea.task.controllers.EmployeeController;
import com.itea.task.dtos.EmployeeDto;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.OK;

public class EmployeeControllerTest {

    @Autowired
    private static EmployeeController controller;

    private static EmployeeDto employee;

    @BeforeClass
    public static void setUp() {
        employee = new EmployeeDto(1L, "test1", 11, null);
        controller.addEmployee(employee);
    }

    @Test
    public void getEmployeesRequestShouldWorkCorrectly() {
        List<EmployeeDto> dtos = controller.getEmployees();
        assertEquals(employee, dtos.get(0));
    }

    @Test
    public void getEmployeeRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(employee, OK), controller.getEmployee(1L));
    }

    @Test
    public void addEmployeeRequestShouldWorkCorrectly() {
        controller.deleteEmployee(1L);
        assertEquals(new ResponseEntity<>(employee, OK), controller.addEmployee(employee));
    }

    @Test
    public void deleteEmployeeRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(1L, OK), controller.deleteEmployee(1L));
        controller.addEmployee(employee);
    }

    @Test
    public void updateEmployeeFRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(employee, OK), controller.updateEmployee(1L, employee));
    }
}
