package com.itea.task.service.impl;

import com.itea.task.entities.UserEntity;
import com.itea.task.repository.UserRepository;
import com.itea.task.service.UserService;
import com.sun.xml.internal.ws.developer.StreamingAttachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.isNull;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public UserEntity add(UserEntity user) {
        return repository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        if (!isNull(get(id))) {
            repository.delete(id);
            return id;
        }
        return null;
    }

    @Override
    @Transactional
    public UserEntity get(Long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional
    public UserEntity update(Long id, UserEntity user) {
        if (!isNull(get(id))) {
            user.setId(repository.findOne(id).getId());
            repository.delete(id);
            repository.saveAndFlush(user);
            return user;
        }
        return null;
    }

    @Override
    @Transactional
    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
