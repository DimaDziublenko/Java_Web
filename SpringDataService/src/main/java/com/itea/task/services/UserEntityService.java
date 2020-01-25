package com.itea.task.services;

import com.itea.task.entities.UserEntity;
import com.itea.task.repositories.UserEntityRepository;
import com.itea.task.services.impl.UserEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService implements UserEntityServiceImpl {

    @Autowired
    private UserEntityRepository userRepository;

    @Override
    public UserEntity add(UserEntity user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public UserEntity get(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserEntity update(UserEntity user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserEntity findOne(Long id) {
        return userRepository.findOne(id);
    }
}
