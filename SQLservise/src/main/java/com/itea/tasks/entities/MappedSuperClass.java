package com.itea.tasks.entities;

import lombok.Getter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
public class MappedSuperClass {

    @Id
    private Integer id;
}
