package com.itea.tasks.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "projects")
@NoArgsConstructor
@Setter
@Getter
public class Project extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "industry")
    private String industry;

    @Column(name = "cost")
    private Double cost;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
    private Set<Developer> developers;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
    private Set<Company> companies;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "projects")
    private Set<Customer> customers;
}
