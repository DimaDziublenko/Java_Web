package com.itea.task.repositories;

import com.itea.task.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyEntityRepository extends JpaRepository<CompanyEntity, Long> {
}
