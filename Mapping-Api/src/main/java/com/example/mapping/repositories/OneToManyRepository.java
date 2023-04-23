package com.example.mapping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mapping.models.Student;




@Repository
public interface OneToManyRepository extends JpaRepository<Student,Long> {
	
	
		 
	

}
