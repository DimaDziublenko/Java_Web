package com.itea.task.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToMany
    @JoinTable(name = "customer_project",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<ProjectEntity> projects;
}