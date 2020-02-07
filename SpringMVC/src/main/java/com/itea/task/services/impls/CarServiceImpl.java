package com.itea.task.services.impls;

import com.itea.task.entities.CarEntity;
import com.itea.task.repositories.CarRepository;
import com.itea.task.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Override
    public CarEntity add(CarEntity car) {
        return repository.saveAndFlush(car);
    }

    @Override
    public Long delete(Long id) {
        if (!isNull(get(id))) {
            repository.deleteById(id);
            return id;
        }
        return null;
    }

    @Override
    public CarEntity get(Long id) {
        return repository.getOne(id);
    }

    @Override
    public CarEntity update(Long id, CarEntity car) {
        if (!isNull(get(id))) {
            car.setId(repository.getOne(id).getId());
            repository.deleteById(id);
            repository.saveAndFlush(car);
            return car;
        }
        return null;
    }

    @Override
    public List<CarEntity> findAll() {
        return repository.findAll();
    }

    @PostConstruct
    public void init() {
    }

    @PreDestroy
    public void destroy() {
    }
}
