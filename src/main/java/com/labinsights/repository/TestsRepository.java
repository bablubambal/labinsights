package com.labinsights.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.labinsights.entity.Tests;





@Repository("testsRepository")
public interface TestsRepository extends CrudRepository<Tests, Long> {
	
	
//	 Tests findByEmail(String name);
	
//	  findByConfirmationToken(String confirmationToken);
	 
	  List<Tests> findAll();
}