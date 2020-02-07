package com.itea.task.service;

import com.itea.task.entities.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity add(UserEntity user);

    Long delete(Long id);

    UserEntity get(Long id);

    UserEntity update(Long id, UserEntity user);

    List<UserEntity> findAll();
}
