package com.julioherrera.school.core.bs.dao;

import com.julioherrera.school.core.eis.bo.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
