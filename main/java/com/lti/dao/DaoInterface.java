package com.lti.dao;

import java.util.List;

import com.lti.pojo.Exam;
import com.lti.pojo.Questions;
import com.lti.pojo.Report;
import com.lti.pojo.Student;

public interface DaoInterface {
	Student createStudent(Student stu);
	List<Student> searchStudentOnConditions(String tech,String state,String city,String levels,int marks);
	List<Student> searchStudentStateAndCity(String state,String city);
	List<Student> searchStudentlevel(String level);
	List<Student> searchAllStudent();
	
	List<Object> searchQuestionsWithLevel(String level,int subjectid);
	
	List<Object> reportStudents(int userid);
	
	List<Object> getAllExam();
	
	List<Object> getAllReport();
	
	List<Object> getFileNames();
	
}
