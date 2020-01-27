package com.itea.task.services;

import com.itea.task.entities.DeveloperEntity;
import com.itea.task.repositories.DeveloperEntityRepository;
import com.itea.task.services.impl.DeveloperEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperEntityService implements DeveloperEntityServiceImpl {

    @Autowired
    private DeveloperEntityRepository developerRepository;

    @Override
    public DeveloperEntity add(DeveloperEntity developer) {
        return developerRepository.saveAndFlush(developer);
    }

    @Override
    public void delete(Long id) {
        developerRepository.delete(id);
    }

    @Override
    public DeveloperEntity get(Long id) {
        return developerRepository.findOne(id);
    }

    @Override
    public DeveloperEntity update(DeveloperEntity developer) {
        return developerRepository.saveAndFlush(developer);
    }

    @Override
    public DeveloperEntity findOne(Long id) {
        return  developerRepository.findOne(id);
    }
}
