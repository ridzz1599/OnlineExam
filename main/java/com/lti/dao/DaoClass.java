package com.lti.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.pojo.Exam;
import com.lti.pojo.Questions;
import com.lti.pojo.Report;
import com.lti.pojo.Student;
import com.lti.repository.ExamRepository;

@Repository
public class DaoClass implements DaoInterface{
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	ExamRepository ex;
	
	
	@Override
	public Student createStudent(Student stu) {
		Student s=em.merge(stu);
		return s;
	}

	@Override
	public List<Student> searchStudentOnConditions(String tech, String state, String city, String levels, int marks) {
		// TODO Auto-generated method stub
		//Query q=em.createQuery("select m from Student m");		
		//List<Student> stulist=q.getResultList();
		
		//Query q=em.createQuery("select s from Student s JOIN s.student_rep r JOIN r.ex_reps");
		//q.setParameter("city",city);
		//q.setParameter("state",state);
		//q.setParameter("levels", levels);
		//q.setParameter("marks",marks);
		//List<Student> stulist=q.getResultList();
		
//		CriteriaBuilder cbr=em.getCriteriaBuilder();
//		CriteriaQuery<Student> criteria=cbr.createQuery(Student.class);
//		Root<Student> root=criteria.from(Student.class);
//		root.join("student_rep");
//		//criteria.where(cbr.isNotEmpty(root.get("")));
//		Query query=em.createQuery(criteria);
//		List<Student> stulist=query.getResultList();
		//return stulist;
//		CriteriaBuilder cbr=em.getCriteriaBuilder();
//		CriteriaQuery<Student> st=cbr.createQuery(Student.class);
//		Root<Student> st
		
		Query q=em.createQuery("select distinct s.student_id,s.username,s.city,s.state,s.YOC,s.mobile,s.qualification,s.dob from Student s JOIN s.student_rep r JOIN r.ex_reps e where s.city=:city AND s.state=:state AND r.levels=:level AND e.exam_name=:Tech AND r.marks_student=:marks");
		q.setParameter("city", city);
		q.setParameter("state", state);
		q.setParameter("level", levels);
		q.setParameter("Tech", tech);
		q.setParameter("marks", marks);
		List<Student> stulist=q.getResultList();
		return stulist;
	}

	@Override
	public List<Student> searchStudentStateAndCity(String state, String city) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select s.student_id,s.username,s.city,s.state,s.YOC,s.mobile,s.qualification,s.dob from Student s where s.state=:state AND s.city=:city");
		q.setParameter("city", city);
		q.setParameter("state",state);
		List<Student> stulist=q.getResultList();
		return stulist;
	}
	@Override
	public List<Student> searchStudentlevel(String level) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select distinct m.student_id,m.username,m.city,m.state,r.levels,r.marks_student,r.status from Student m JOIN m.student_rep r where r.levels=:level");
		q.setParameter("level", level);
		List<Student> stulist=q.getResultList();
		return stulist;
	}

	@Override
	public List<Student> searchAllStudent() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select s.student_id,s.username,s.city,s.state,s.YOC,s.mobile,s.qualification,s.dob from Student s");
		List<Student> stulist=q.getResultList();
		return stulist;
	}

	@Override
	public List<Object> searchQuestionsWithLevel(String level,int subjectid) {
		// TODO Auto-generated method stub
		System.out.println(subjectid);
		System.out.println(level);
		Query q=em.createQuery("select e.exam_id,e.exam_name,e.duration,e.no_of_questions,e.passing_score,m.QuestionNo,m.Question,m.Option1,m.Option2,m.Option3,m.Option4,m.Answer,m.Level_ques from Exam e JOIN e.ques m where e.exam_id=:subjectid AND m.Level_ques=:level");
		//Query q=em.createQuery("select m.Question from Questions m JOIN m.exam_ques e where m.Level_ques=:level AND e.exam_id=:subjectid");
		q.setParameter("subjectid", subjectid);
		
		q.setParameter("level",level);
		List<Object> quelist=q.getResultList();
		return quelist;
	}

	@Override
	public List<Object> reportStudents(int userid) {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select s.username,r.marks_student,r.levels,r.status,e.exam_name from Student s JOIN s.student_rep r JOIN r.ex_reps e WHERE s.student_id=:userid");
		q.setParameter("userid", userid);
		List<Object> replist=q.getResultList();
		System.out.println(replist);
		return replist;
	}
	
	@Override
	public List<Object> getAllExam() {
		Query q=em.createQuery("select n.exam_id,n.exam_name from Exam n");
		List<Object> examList=q.getResultList();
		return examList;
	}
	@Override
	public List<Object> getAllReport() {
		Query q=em.createQuery("select m.report_id,m.levels,m.status,m.marks_student from Report m");
		List<Object> replist=q.getResultList();
		return replist;
	}
	
	@Override
	public List<Object> getFileNames(){
		Query q=em.createQuery("select m.filename,m.exam_name from Exam m");
		List<Object> filelist=q.getResultList();
		return filelist;
	}
	
}
