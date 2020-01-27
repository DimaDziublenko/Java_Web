package com.itea.task.repositories;

import com.itea.task.entities.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperEntityRepository extends JpaRepository<DeveloperEntity, Long> {
}
