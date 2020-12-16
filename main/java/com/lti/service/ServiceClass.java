package com.lti.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Service;

import com.lti.dao.DaoClass;
import com.lti.pojo.Exam;
import com.lti.pojo.Questions;
import com.lti.pojo.Report;
import com.lti.pojo.Student;
import com.lti.repository.ExamRepository;
import com.lti.repository.ReportRepository;
import com.lti.repository.StudentReository;

@Service
@Transactional
public class ServiceClass {
	@Autowired
	DaoClass dao;
	@Autowired
	StudentReository re;
	
	@Autowired
	ExamRepository ex;
	
	@Autowired
	StudentReository stu;
	
	@Autowired
	ReportRepository rep;
	
	@Autowired
	EntityManager em;
	public Student createStudent(Student stu) {
		return dao.createStudent(stu);
	}

	public List<Student> getStudents(String tech, String state, String city, String levels, int marks) {
		return dao.searchStudentOnConditions(tech, state, city, levels, marks);
	}

	public List<Student> getStudentStateAndCity(String state, String city) {
		return dao.searchStudentStateAndCity(state, city);
	}

	public List<Student> searchStudentlevel(String level) {
		return dao.searchStudentlevel(level);
	}

	public List<Student> getAllStudents() {
		return dao.searchAllStudent();
	}
	
	public List<Object> getQuestionsByLevels(String level,int  subject){
		return dao.searchQuestionsWithLevel(level,subject);
	}
	
	public List<Object> repStudent(int student_id){
		return dao.reportStudents(student_id);
	}
	
	public String createReport(String level,int score,String status,int examid,int userid) {
		Optional<Student> s=stu.findById(userid);
		Student student=s.get();
		Report r=new Report(level,score,status);
		student.getStudent_rep().add(r);
		r.setStu_reps(student);
		Optional<Exam> e=ex.findById(examid);
		Exam e1=e.get();
		e1.getRep().add(r);
		r.setEx_reps(e1);
		rep.save(r);
		
		
		return null;
	}
	public String craeteStudentTakes(int student_id,int examid) {
		Optional<Student> s=stu.findById(student_id);
		Student student=s.get();
		
		Optional<Exam> e=ex.findById(examid);
		Exam e1=e.get();
		
		student.getExams().add(e1);
		e1.getStudents().add(student);
		
		stu.save(student);
		ex.save(e1);
		
		return null;
	}
	public List<Object> getAllExam() 
	{
	return dao.getAllExam();
	}
	
	public List<Object> getAllReport() 
	{
	return dao.getAllReport();
	}
	public List<Object> getFileNames(){
		return dao.getFileNames();
	}
}
