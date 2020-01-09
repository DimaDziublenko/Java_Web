package com.itea.tasks.entities;

import lombok.Getter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public class BaseEntity {

    @Id
    private Integer id;
}
