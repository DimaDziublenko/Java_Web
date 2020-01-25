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
@Table(name = "developers")
public class DeveloperEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "salary")
    private Double salary;

    @ManyToMany
    @JoinTable(name = "developer_project",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<ProjectEntity> projects;

    @ManyToMany
    @JoinTable(name = "developer_skill",
            joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"))
    private Set<SkillEntity> skills;
}