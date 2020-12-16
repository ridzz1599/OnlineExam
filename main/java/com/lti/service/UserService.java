package com.lti.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lti.pojo.Student;

@Service
public interface UserService {
    public Optional<Student> findUserByEmailId(String emailId);
    public Optional<Student> findUserByResetToken(String resetToken);
    public void save(Student student);
}
