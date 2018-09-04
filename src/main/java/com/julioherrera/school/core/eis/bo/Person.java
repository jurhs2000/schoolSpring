package com.julioherrera.school.core.eis.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "hire_date")
    private Date hireDate;
    @Column(name = "enrollment_date")
    private Date enrollmentDate;
    @OneToMany(mappedBy = "person")
    @Column(name = "student_id")
    private Set<StudentGrade> studentGrade;
    @OneToMany(mappedBy = "person")
    private Set<CourseInstructor> courseInstructors;
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "person")
    //@OneToOne(optional = false)
    //@JoinColumn(name = "instructor_id", nullable = false, insertable = false, updatable = false)
    //@OneToOne(optional = false, mappedBy = "person")
    //@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    //@JoinColumn(name = "person_id")
    //@OneToOne(optional = false)
    //@JoinColumn(name = "officjdfnsjkgbsdkjghjkdgent", unique = true)
    private OfficeAssignment officeAssignment;
}
