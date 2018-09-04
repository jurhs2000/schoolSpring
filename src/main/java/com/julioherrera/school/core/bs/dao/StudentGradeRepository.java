package com.julioherrera.school.core.bs.dao;

import com.julioherrera.school.core.eis.bo.StudentGrade;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentGradeRepository extends PagingAndSortingRepository<StudentGrade, Long> {
}
