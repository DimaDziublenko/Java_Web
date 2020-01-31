package com.itea.task.services;

import com.itea.task.entities.CompanyEntity;

import java.util.List;

public interface CompanyService {

    CompanyEntity add(CompanyEntity company);

    Long delete(Long id);

    CompanyEntity get(Long id);

    CompanyEntity update(Long id, CompanyEntity company);

    List<CompanyEntity> findAll();
}
