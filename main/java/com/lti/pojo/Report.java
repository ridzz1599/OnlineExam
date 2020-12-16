package com.lti.pojo;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reports")
public class Report {
	@Id
	@GeneratedValue
	private int report_id;
	//private String report_name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="exam_id",nullable = false)
	private Exam ex_reps;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="student_id",nullable = false)
	private Student stu_reps;
	
	private String levels;
	private String status;
	private int marks_student;
	
	@Column(name = "date_report_gen", columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date date_report_gen;

	public Report() {
		
	}

	public int getReport_id() {
		return report_id;
	}

	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}

//	public String getReport_name() {
//		return report_name;
//	}
//
//	public void setReport_name(String report_name) {
//		this.report_name = report_name;
//	}

	public Exam getEx_reps() {
		return ex_reps;
	}

	public void setEx_reps(Exam ex_reps) {
		this.ex_reps = ex_reps;
	}

	public Student getStu_reps() {
		return stu_reps;
	}

	public void setStu_reps(Student stu_reps) {
		this.stu_reps = stu_reps;
	}
	

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}
	

	public int getMarks_student() {
		return marks_student;
	}

	public void setMarks_student(int marks_student) {
		this.marks_student = marks_student;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate_report_gen() {
		return date_report_gen;
	}

	public void setDate_report_gen(Date date_report_gen) {
		this.date_report_gen = date_report_gen;
	}

	public Report(Exam ex_reps, Student stu_reps, String levels, String status, int marks_student) {
		super();
		this.ex_reps = ex_reps;
		this.stu_reps = stu_reps;
		this.levels = levels;
		this.status = status;
		this.marks_student = marks_student;
	}

	public Report(Student stu_reps, String levels, String status, int marks_student) {
		super();
		this.stu_reps = stu_reps;
		this.levels = levels;
		this.status = status;
		this.marks_student = marks_student;
	}

	public Report(String levels,int marks_student, String status) {
		super();
		this.levels = levels;
		this.status = status;
		this.marks_student = marks_student;
	}
	
	
}
