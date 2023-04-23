package com.example.mapping.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapping.models.Company;
import com.example.mapping.projections.DetailsProjection;
import com.example.mapping.repositories.OneToOneRepository;

@Service
public class OneToOneService {
	
	@Autowired
	OneToOneRepository oneRepo;
	
	
	 // CREATE 
    public Company createCompany(Company com) {
    	System.out.println("step 3 ok");
        return oneRepo.save(com);
    }

   
	// READ specific columns
	public Collection<DetailsProjection> getCompany(long id) {

		return oneRepo.findCollection(id);
	}
	//Read * from company and employee
	public List<Company> getall() {
		return oneRepo.findAll();
	}
	
}
