package com.itea.task.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "project")
public class ProjectEntity extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "industry")
    private String industry;

    @Column(name = "cost")
    private Double cost;

    @ManyToMany(mappedBy = "projects")
    private Set<DeveloperEntity> developers;

    @ManyToMany(mappedBy = "projects")
    private Set<CompanyEntity> companies;

    @ManyToMany(mappedBy = "projects")
    private Set<CustomerEntity> customers;
}