package com.itea.task.services;

import com.itea.task.entities.CompanyEntity;
import com.itea.task.repositories.CompanyEntityRepository;
import com.itea.task.services.impl.CompanyEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyEntityService implements CompanyEntityServiceImpl {

    @Autowired
    private CompanyEntityRepository companyRepository;

    @Override
    public CompanyEntity add(CompanyEntity company) {
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public void delete(Long id) {
        companyRepository.delete(id);
    }

    @Override
    public CompanyEntity get(Long id) {
        return companyRepository.findOne(id);
    }

    @Override
    public CompanyEntity update(CompanyEntity company) {
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public CompanyEntity findOne(Long id) {
        return companyRepository.findOne(id);
    }
}
