package com.example.mapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapping.model.User;
import com.example.mapping.service.PaginationAndSortingService;


@RestController
public class PaginationAndSortingController {
	@Autowired
	PaginationAndSortingService service;

	  @RequestMapping(value = "/paging/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	    public List<User> employeePagination(@PathVariable int pageNumber, @PathVariable int pageSize){

	        return service.getEmployeePagination(pageNumber,pageSize);
	    }
	  
	  
	

	   

	  
}
