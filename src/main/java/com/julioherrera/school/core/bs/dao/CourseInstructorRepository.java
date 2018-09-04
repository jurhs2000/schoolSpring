package com.julioherrera.school.core.bs.dao;

import com.julioherrera.school.core.eis.bo.CourseInstructor;
import com.julioherrera.school.core.eis.bo.CourseInstructorId;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseInstructorRepository extends PagingAndSortingRepository<CourseInstructor, CourseInstructorId> {
}
