package com.example.mapping.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapping.models.Company;
import com.example.mapping.projections.DetailsProjection;
import com.example.mapping.services.OneToOneService;

@RestController
@RequestMapping("/api")
public class OneToOneController {

	@Autowired
	OneToOneService Oneservice;
	
	// add company and employee
	@RequestMapping(value = "/company", method = RequestMethod.POST)
	public Company createEmployee(@RequestBody Company com) {

		System.out.println("step2 ok");
		return Oneservice.createCompany(com);
	}
	//get company and employee specific columns
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
	public Collection<DetailsProjection> readCompany(@PathVariable(value = "id") long id) {
		return Oneservice.getCompany(id);
	}
	//get * company and employees
	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public List<Company> readAllCompany() {
		return Oneservice.getall();
	}
}
