package com.lti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.pojo.Student;

@Repository
public interface RegistrationRepository extends JpaRepository<Student,Integer>{

	public Student findByEmailId(String emailId);
	public Student findByEmailIdAndPassword(String emailId , String password);
}
