package com.itea.task.services.impls;

import com.itea.task.entities.EmployeeEntity;
import com.itea.task.repositories.EmployeeRepository;
import com.itea.task.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeEntity add(EmployeeEntity employee) {
        return repository.saveAndFlush(employee);
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
    public EmployeeEntity get(Long id) {
        return repository.getOne(id);
    }

    @Override
    public EmployeeEntity update(Long id, EmployeeEntity employee) {
        if (!isNull(get(id))) {
            employee.setId(repository.getOne(id).getId());
            repository.deleteById(id);
            repository.saveAndFlush(employee);
            return employee;
        }
        return null;
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return repository.findAll();
    }

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void destroy() {
    }
}
