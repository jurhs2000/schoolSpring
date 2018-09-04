package com.julioherrera.school.core.eis.bo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseInstructorId implements Serializable {
    @Column(name = "course_id", nullable = false, insertable = false, updatable = false)
    private Long courseId;
    @Column(name = "person_id", nullable = false, insertable = false, updatable = false)
    private Long personId;
}
