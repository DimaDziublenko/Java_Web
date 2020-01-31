package com.itea.task.controllerTests;

import com.itea.task.controllers.CarController;
import com.itea.task.dtos.CarDto;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.OK;

@Component
public class CarControllerTest {

    @Autowired
    private static CarController controller;

    private static CarDto car;

    @BeforeClass
    public static void setUp() {
        car = new CarDto(1L, "test1", 1.1F, 1111L, null);
        controller.addCar(car);
    }

    @Test
    public void getCarsRequestShouldWorkCorrectly() {
        List<CarDto> dtos = controller.getCars();
        assertEquals(car, dtos.get(0));
    }

    @Test
    public void getCarRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(car, OK), controller.getCar(1L));
    }

    @Test
    public void addCarRequestShouldWorkCorrectly() {
        controller.deleteCar(1L);
        assertEquals(new ResponseEntity<>(car, OK), controller.addCar(car));
    }

    @Test
    public void deleteCarRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(1L, OK), controller.deleteCar(1L));
        controller.addCar(car);
    }

    @Test
    public void updateCarRequestShouldWorkCorrectly() {
        assertEquals(new ResponseEntity<>(car, OK), controller.updateCar(1L, car));
    }
}
