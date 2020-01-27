package com.itea.task.services.impl;

import com.itea.task.entities.DeveloperEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeveloperEntityServiceImpl {

    DeveloperEntity add(DeveloperEntity developer);

    void delete(Long id);

    DeveloperEntity get(Long id);

    DeveloperEntity update(DeveloperEntity developer);

    @Query("SELECT d FROM developer AS d WHERE d.id = :id")
    DeveloperEntity findOne(@Param("id") Long id);
}
