package com.itea.task.services.impl;

import com.itea.task.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserEntityServiceImpl {

    UserEntity add(UserEntity user);

    void delete(Long id);

    UserEntity get(Long id);

    UserEntity update(UserEntity user);

    @Query("SELECT u FROM user AS u WHERE u.id = :id")
    UserEntity findOne(@Param("id") Long id);
}
