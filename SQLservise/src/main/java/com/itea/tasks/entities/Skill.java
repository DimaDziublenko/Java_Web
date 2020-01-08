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
@Table(name = "skills")
@NoArgsConstructor
@Setter
@Getter
public class Skill extends MappedSuperClass {

    @Column(name = "industry")
    private String industry;

    @Column(name = "skill_level")
    private String skillLevel;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "skills")
    private Set<Developer> developers;
}
