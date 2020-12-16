package com.lti.repository;

import org.springframework.data.repository.CrudRepository;

import com.lti.pojo.Exam;

public interface ExamRepository extends CrudRepository<Exam,Integer> {
}
