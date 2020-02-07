package com.itea.task.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
public class CarEntity extends BaseEntity {

    @Column(name = "model")
    private String model;

    @Column(name = "engine_capacity")
    private Float engineCapacity;

    @Column(name = "mileage")
    private Long mileage;

    @OneToOne(mappedBy = "car")
    private EmployeeEntity employee;
}
