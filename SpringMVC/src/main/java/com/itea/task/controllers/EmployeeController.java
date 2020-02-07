package com.itea.task.controllers;

import com.itea.task.dtos.EmployeeDto;
import com.itea.task.entities.EmployeeEntity;
import com.itea.task.mappers.EmployeeMapper;
import com.itea.task.services.EmployeeService;
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
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private EmployeeMapper mapper;

    private static final String NOT_FOUND_MESSAGE = "No employees found for ID: ";

    @GetMapping("/employees")
    public List<EmployeeDto> getEmployees() {
        List<EmployeeEntity> entities = service.findAll();
        List<EmployeeDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapper.toDto(e)));
        return dtos;
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") Long id) {
        return isNull(service.get(id)) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(mapper.toDto(service.get(id)), OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employee) {
        service.add(mapper.toEntity(employee));
        return new ResponseEntity<>(employee, OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        return isNull(service.delete(id)) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(id, OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employee) {
        employee = mapper.toDto(service.update(id, mapper.toEntity(employee)));
        return isNull(employee) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(employee, OK);
    }
}
