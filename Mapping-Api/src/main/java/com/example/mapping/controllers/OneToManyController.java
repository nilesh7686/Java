package com.example.mapping.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RestController;

import com.example.mapping.models.Student;
import com.example.mapping.repositories.OneToManyRepository;






@RestController
public class OneToManyController {
	@Autowired
	OneToManyRepository repo;
	
		//add student and laptops
	@PostMapping("/add")
	public List<Student> add(@RequestBody List<Student> student) {
		System.out.println("controller");
		return repo.saveAll(student);

	}
		//retrive all data
	@GetMapping("/get")
	public List<Student> get(){
		return repo.findAll();
	}
	//find data by id
	@GetMapping("/get/{id}")
	public Optional<Student> get(@PathVariable Long id){
		return repo.findById(id);
	}
	

}
