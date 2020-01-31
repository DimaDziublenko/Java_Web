package com.itea.task.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class CompanyEntity extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Date date;

    @Column(name = "cost")
    private Float cost;
}
