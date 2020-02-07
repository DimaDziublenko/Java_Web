package com.itea.task.controllerTests;

import com.itea.task.configs.DataConfig;
import com.itea.task.controllers.CarController;
import com.itea.task.dtos.CarDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpStatus.OK;

@DirtiesContext
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DataConfig.class)
public class CarControllerTest {

    @Autowired
    private CarController controller;

    private CarDto car;

    @Test
    public void getCarShouldWorkCorrectly() {
        car = new CarDto(1L, "getCarTest", 11.1F, 11111L, null);
        controller.addCar(car);
        assertEquals(OK, controller.getCar(1L).getStatusCode());
    }

    @Test
    public void getCarsShouldWorkCorrectly() {
        car = new CarDto(2L, "getCarsTest", 22.2F, 22222L, null);
        controller.addCar(car);
        List<CarDto> cars = controller.getCars();
        assertNotNull(cars.get(0));
    }

    @Test
    public void addCarShouldWorkCorrectly() {
        car = new CarDto(3L, "addCarTest", 33.3F, 33333L, null);
        assertEquals(OK, controller.addCar(car).getStatusCode());
    }

    @Test
    public void deleteCarShouldWorkCorrectly() {
        car = new CarDto(4L, "deleteCarTest", 44.4F, 44444L, null);
        controller.addCar(car);
        assertEquals(OK, controller.deleteCar(4L).getStatusCode());
    }

    @Test
    public void updateCarShouldWorkCorrectly() {
        car = new CarDto(5L, "updateCarTest", 55.5F, 55555L, null);
        controller.addCar(car);
        assertEquals(OK, controller.updateCar(6L, car).getStatusCode());
    }
}
