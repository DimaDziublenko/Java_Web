package com.itea.task.services.impl;

import com.itea.task.entities.CompanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyEntityServiceImpl {

    CompanyEntity add(CompanyEntity company);

    void delete(Long id);

    CompanyEntity get(Long id);

    CompanyEntity update(CompanyEntity company);

    @Query("SELECT c FROM company AS c WHERE c.id = :id")
    CompanyEntity findOne(@Param("id") Long id);
}
