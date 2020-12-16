package com.lti.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.pojo.Student;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Student, Integer> {
	 Optional<Student> findByEmailId(String emailId);
	 Optional<Student> findByResetToken(String resetToken);
}