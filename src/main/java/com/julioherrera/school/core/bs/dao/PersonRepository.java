package com.julioherrera.school.core.bs.dao;

import com.julioherrera.school.core.eis.bo.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
