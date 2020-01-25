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
@Table(name = "company")
public class CompanyEntity extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "industry")
    private String industry;

    @ManyToMany
    @JoinTable(name = "company_project",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<ProjectEntity> projects;
}