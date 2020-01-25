package com.itea.task.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "additional_info")
    private Map<String, Object> additionalInfo;
}
