package com.itea.task.services.impls;

import com.itea.task.entities.CompanyEntity;
import com.itea.task.repositories.CompanyRepository;
import com.itea.task.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Override
    public CompanyEntity add(CompanyEntity company) {
        return repository.saveAndFlush(company);
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
    public CompanyEntity get(Long id) {
        return repository.getOne(id);
    }

    @Override
    public CompanyEntity update(Long id, CompanyEntity company) {
        if (!isNull(get(id))) {
            company.setId(repository.getOne(id).getId());
            repository.deleteById(id);
            repository.saveAndFlush(company);
            return company;
        }
        return null;
    }

    @Override
    public List<CompanyEntity> findAll() {
        return repository.findAll();
    }

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void destroy() {
    }
}
