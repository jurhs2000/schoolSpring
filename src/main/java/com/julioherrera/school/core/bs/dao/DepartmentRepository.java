package com.julioherrera.school.core.bs.dao;

import com.julioherrera.school.core.eis.bo.Department;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepartmentRepository extends PagingAndSortingRepository<Department, Long> {
}
