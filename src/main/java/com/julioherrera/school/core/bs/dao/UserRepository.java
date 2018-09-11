package com.julioherrera.school.core.bs.dao;

import com.julioherrera.school.core.eis.bo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}
