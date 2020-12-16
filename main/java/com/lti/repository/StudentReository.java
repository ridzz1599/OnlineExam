package com.lti.repository;



import org.springframework.data.repository.CrudRepository;

import com.lti.pojo.Student;

public	interface StudentReository extends CrudRepository<Student,Integer> {
}
