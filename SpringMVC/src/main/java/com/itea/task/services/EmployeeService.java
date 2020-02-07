package com.itea.task.services;

import com.itea.task.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity add(EmployeeEntity employee);

    Long delete(Long id);

    EmployeeEntity get(Long id);

    EmployeeEntity update(Long id, EmployeeEntity employee);

    List<EmployeeEntity> findAll();
}
