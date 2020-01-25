package com.itea.task.entities;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;
}
