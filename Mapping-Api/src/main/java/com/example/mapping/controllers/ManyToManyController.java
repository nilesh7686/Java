package com.example.mapping.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapping.models.Posts;
import com.example.mapping.repositories.ManyToManyRepository;


@RestController
public class ManyToManyController {
	
	@Autowired
	ManyToManyRepository repo;
	
	@PostMapping("/save")
	public List<Posts> add(@RequestBody List<Posts> post) {
		System.out.println("controller");
		return repo.saveAll(post);

	}
		//retrive all data
	@GetMapping("/fetch")
	public List<Posts> get(){
		return repo.findAll();
	}
	//find data by id
	@GetMapping("/fetch/{id}")
	public Optional<Posts> get(@PathVariable Long id){
		return repo.findById(id);
	}
	

}
