package com.example.mapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.mapping.model.User;
import com.example.mapping.repository.PaginationRepository;
import com.example.mapping.repository.UserRepository;

@Service
public class PaginationAndSortingService {
	@Autowired
	PaginationRepository repo;
	
	public List<User> getEmployeePagination(int pageNumber, int pageSize) {
       
		 Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<User> pagedResult = repo.findAll(paging);
      
        return  pagedResult.toList();
    }

	
	
	

}
