package com.itea.tasks.entities;

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
@Table(name = "companies")
@NoArgsConstructor
@Setter
@Getter
public class Company extends MappedSuperClass {

    @Column(name = "title")
    private String title;

    @javax.persistence.Column(name = "industry")
    private String industry;

    @ManyToMany
    @JoinTable(name = "company_project",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<Project> projects;
}
