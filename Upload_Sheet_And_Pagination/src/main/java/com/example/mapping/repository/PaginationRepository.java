package com.example.mapping.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.mapping.model.User;
@Repository
public interface PaginationRepository extends PagingAndSortingRepository<User, Long> {

	Page<User> findAll(Pageable paging);

}
