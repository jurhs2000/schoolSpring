package com.julioherrera.school.core.bs.dao;

import com.julioherrera.school.core.eis.bo.OnlineCourse;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OnlineCourseRepository extends PagingAndSortingRepository<OnlineCourse, Long> {
}
