package com.itea.task.controllers;

import com.itea.task.dtos.CarDto;
import com.itea.task.entities.CarEntity;
import com.itea.task.mappers.CarMapper;
import com.itea.task.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class CarController {

    @Autowired
    private CarService service;

    @Autowired
    private CarMapper mapper;

    private static final String NOT_FOUND_MESSAGE = "No car found for ID: ";

    @GetMapping("/cars")
    public List<CarDto> getCars() {
        List<CarEntity> entities = service.findAll();
        List<CarDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapper.toDto(e)));
        return dtos;
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<?> getCar(@PathVariable("id") Long id) {
        return isNull(service.get(id)) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(mapper.toDto(service.get(id)), OK);
    }

    @PostMapping("/cars")
    public ResponseEntity<?> addCar(@RequestBody CarDto car) {
        service.add(mapper.toEntity(car));
        return new ResponseEntity<>(car, OK);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id) {
        return isNull(service.delete(id)) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(id, OK);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<?> updateCar(@PathVariable("id") Long id, @RequestBody CarDto car) {
        car = mapper.toDto(service.update(id, mapper.toEntity((car))));
        return isNull(car) ?
                new ResponseEntity<>(NOT_FOUND_MESSAGE + id, NOT_FOUND) :
                new ResponseEntity<>(car, OK);
    }
}
