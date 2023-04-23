package com.example.mapping.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.mapping.models.Company;
import com.example.mapping.projections.DetailsProjection;

@Repository
public interface OneToOneRepository extends JpaRepository<Company, Long> {
	
	@Query("select new com.example.mapping.projections.DetailsProjection(c.companyName,c.mobileNo,e.firstName) from Company c JOIN c.employee e ")
	public Collection<DetailsProjection> findCollection(long id);



}
