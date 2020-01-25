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
@Table(name = "skills")
public class SkillEntity extends BaseEntity {

    @Column(name = "industry")
    private String industry;

    @Column(name = "skill_level")
    private String skillLevel;

    @ManyToMany(mappedBy = "skills")
    private Set<DeveloperEntity> developers;
}