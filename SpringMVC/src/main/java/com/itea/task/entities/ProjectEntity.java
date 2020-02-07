package com.itea.task.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
public class ProjectEntity extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private Float cost;
}
