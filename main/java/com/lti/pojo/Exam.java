
package com.lti.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam{
	@Id
	@GeneratedValue
	private int exam_id;
	private String exam_name;
	private int duration;
	private int no_of_questions;
	private int passing_score;
	private String filename;
	
	
	
	@ManyToMany(mappedBy = "exams", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Student> students = new ArrayList<Student>();
	
	@OneToMany(mappedBy = "ex_reps",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Report> rep=new ArrayList<Report>();
	
	@OneToMany(mappedBy = "exam_ques",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Questions> ques=new ArrayList<Questions>();
	
	public int getExam_id() {
		return exam_id;
	}

	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}

	
	

	public Exam() {
		
	}

	public Exam(String exam_name) {
		super();
		this.exam_name = exam_name;
	}

	

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getNo_of_questions() {
		return no_of_questions;
	}

	public void setNo_of_questions(int no_of_questions) {
		this.no_of_questions = no_of_questions;
	}

	public int getPassing_score() {
		return passing_score;
	}

	public void setPassing_score(int passing_score) {
		this.passing_score = passing_score;
	}

	

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Report> getRep() {
		return rep;
	}

	public void setRep(List<Report> rep) {
		this.rep = rep;
	}

	public List<Questions> getQues() {
		return ques;
	}

	public void setQues(List<Questions> ques) {
		this.ques = ques;
	}

	public Exam(int exam_id, String exam_name, int duration, int no_of_questions, int passing_score) {
		super();
		this.exam_id = exam_id;
		this.exam_name = exam_name;
		this.duration = duration;
		this.no_of_questions = no_of_questions;
		this.passing_score = passing_score;
	}
	

	public Exam(int exam_id, String exam_name, int duration, int no_of_questions, int passing_score,
			List<Questions> ques) {
		super();
		this.exam_id = exam_id;
		this.exam_name = exam_name;
		this.duration = duration;
		this.no_of_questions = no_of_questions;
		this.passing_score = passing_score;
		this.ques = ques;
	}
	

	public Exam(String exam_name, int duration, int no_of_questions, int passing_score) {
		super();
		this.exam_name = exam_name;
		this.duration = duration;
		this.no_of_questions = no_of_questions;
		this.passing_score = passing_score;
	}
	

	public Exam(String exam_name, int duration, int no_of_questions, int passing_score, String filename) {
		super();
		this.exam_name = exam_name;
		this.duration = duration;
		this.no_of_questions = no_of_questions;
		this.passing_score = passing_score;
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "Exam [exam_id=" + exam_id + ", exam_name=" + exam_name + ", duration=" + duration + ", no_of_questions="
				+ no_of_questions + ", passing_score=" + passing_score + ", ques=" + ques + "]";
	}

	

	
	
	
}