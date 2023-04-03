


package com.labinsights.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labinsights.entity.Tests;
import com.labinsights.repository.TestsRepository;


 
@Service("testsService")
public class TestsService {

//	private TestsRepository testsRepository;
	private TestsRepository testsRepository;

	@Autowired
	public TestsService(TestsRepository testsRepository) {
		this.testsRepository = testsRepository;
	}
	
//	public Tests findByEmail(String email) {
//		return testsRepository.findByEmail(email);
//	}
	
//	public Tests findByConfirmationToken(String confirmationToken) {
//		return testsRepository.findByConfirmationToken(confirmationToken);
//	}
	
	public void saveTests(Tests tests) {
		testsRepository.save(tests);
	}
	
	public List<Tests> findAll() {
		
		return testsRepository.findAll();
	}

}