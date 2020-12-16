package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.pojo.Student;
import com.lti.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repo;

	public Student saveUser(Student student) {
		return repo.save(student);
	}
	public Student fetchUserByemailId(String emailId){
		return repo.findByEmailId(emailId);
		
	}
	public Student fetchUserByemailIdAndPassword(String emailId , String password){
		return repo.findByEmailIdAndPassword(emailId, password);
		
	}
}
