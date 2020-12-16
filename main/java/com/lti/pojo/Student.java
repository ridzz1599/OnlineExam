package com.lti.pojo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int student_id;
	private String username;
	private String emailId;
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "cpassword", nullable = false)
	private String cpassword;
	
	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "last_login")
	private Date lastLogin;

	@Column(name = "reset_token")
	private String resetToken;
	private String student_name;
	private String city;
	private String state;
	private int YOC;
	private long mobile;
	private String qualification;
	private Date dob;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)

	@JoinTable(name = "takes", joinColumns = {
			@JoinColumn(name = "student_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "exam_id", nullable = false, updatable = false) })

	private List<Exam> exams = new ArrayList<Exam>();
	
	@OneToMany(mappedBy = "stu_reps",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Report> student_rep=new ArrayList<Report>();
	

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

	public Student(String student_name, String city, String state) {
		super();
		this.student_name = student_name;
		this.city = city;
		this.state = state;
	}

	public Student() {

	}

	

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<Report> getStudent_rep() {
		return student_rep;
	}

	public void setStudent_rep(List<Report> student_rep) {
		this.student_rep = student_rep;
	}

	public int getYOC() {
		return YOC;
	}

	public void setYOC(int yOC) {
		YOC = yOC;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	

	public Student(Integer student_id, String username, String emailId, String password, String cpassword,
			Date createdOn, Date lastLogin, String resetToken, String student_name, String city, String state,
			int yOC, long mobile, String qualification, Date dob, List<Exam> exams, List<Report> student_rep) {
		super();
		this.student_id = student_id;
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.cpassword = cpassword;
		this.createdOn = createdOn;
		this.lastLogin = lastLogin;
		this.resetToken = resetToken;
		this.student_name = student_name;
		this.city = city;
		this.state = state;
		YOC = yOC;
		this.mobile = mobile;
		this.qualification = qualification;
		this.dob = dob;
		this.exams = exams;
		this.student_rep = student_rep;
	}
	

	public Student(String student_name, String city, String state, int yOC, long mobile, String qualification,
			Date dob) {
		super();
		this.student_name = student_name;
		this.city = city;
		this.state = state;
		YOC = yOC;
		this.mobile = mobile;
		this.qualification = qualification;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", city=" + city + ", state="
				+ state + ", YOC=" + YOC + ", mobile=" + mobile + ", qualification=" + qualification + ", dob=" + dob
				+ ", exams=" + exams + ", student_rep=" + student_rep + "]";
	}
	
	
}
