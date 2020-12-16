package com.lti;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lti.pojo.Exam;
import com.lti.pojo.Student;
import com.lti.repository.ExamRepository;
import com.lti.repository.StudentReository;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@SpringBootApplication
public class OnlineExam4Application {

	public static void main(String[] args) {
		SpringApplication.run(OnlineExam4Application.class, args);
	}
//	@Bean
//	public CommandLineRunner mappingDemo(StudentReository studentReository,ExamRepository examRepository) {
//		return args->{
//			Student stu=new Student("Riddhi Doshi","Maha","Maha");
//			
//			studentReository.save(stu);
//			
//			Exam e1=new Exam("Java");
//			Exam e2=new Exam("SQL");
//			
//			examRepository.saveAll(Arrays.asList(e1,e2));
	
	
//			stu.getExams().addAll(Arrays.asList(e1,e2));
//			
//			studentReository.save(stu);
//			
//		};
//	}

}
