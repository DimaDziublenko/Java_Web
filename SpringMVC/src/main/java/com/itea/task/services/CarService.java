package com.itea.task.services;

import com.itea.task.entities.CarEntity;

import java.util.List;

public interface CarService {

    CarEntity add(CarEntity car);

    Long delete(Long id);

    CarEntity get(Long id);

    CarEntity update(Long id, CarEntity car);

    List<CarEntity> findAll();
}
