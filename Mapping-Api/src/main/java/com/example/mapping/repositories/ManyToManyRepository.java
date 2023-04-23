package com.example.mapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mapping.models.Posts;



public interface ManyToManyRepository extends JpaRepository<Posts, Long> {
	
	 

}
