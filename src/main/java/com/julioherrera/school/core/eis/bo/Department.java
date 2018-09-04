package com.julioherrera.school.core.eis.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_iD")
    private Long departmentID;
    @Column(name = "name")
    private String name;
    @Column(name = "budget")
    private Double budget;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "administrator")
    private String administrator;
    @OneToMany(mappedBy = "department")
    private Set<Course> course;
}
