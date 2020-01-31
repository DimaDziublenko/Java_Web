package com.itea.task.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private Long id;

    private String model;

    private Float engineCapacity;

    private Long mileage;

    private EmployeeDto employee;
}
