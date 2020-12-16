package com.lti.controller;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.pojo.Exam;
import com.lti.pojo.Questions;
import com.lti.pojo.Student;
import com.lti.service.ServiceClass;

@RestController
@RequestMapping("/controller")
@CrossOrigin("http://localhost:4200")
public class MainController {
	@Autowired
	ServiceClass ser;
	
	
	@PostMapping("/studentCreation")
	public ResponseEntity<String> studentCreate(@RequestBody Student stu){
		Student s=ser.createStudent(stu);
		if (s == null) {
			return new ResponseEntity<String>("Error", new org.springframework.http.HttpHeaders(), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Student created successfully", new org.springframework.http.HttpHeaders(), HttpStatus.OK);
		}
	}
	@GetMapping("/searchstudents")
	public ResponseEntity<List<Student>> getStudents(@RequestParam(value="Tech") String Tech,@RequestParam(value="city") String city,@RequestParam(value="state") String state,@RequestParam(value="levels") String levels,@RequestParam(value="marks") int marks) {
		List<Student> stulist=ser.getStudents(Tech, state, city, levels, marks);
		return new ResponseEntity<List<Student>>(stulist,HttpStatus.OK);
	}
	@GetMapping("/searchstudentsStateCity")
	public ResponseEntity<List<Student>> getStudentsStateAndCity(@RequestParam(value="city") String city,@RequestParam(value="state") String state) {
		List<Student> stulist=ser.getStudentStateAndCity(state, city);
		return new ResponseEntity<List<Student>>(stulist,HttpStatus.OK);
	}
	@GetMapping("/searchstudentsLevel")
	public ResponseEntity<List<Student>> getStudentsLevel(@RequestParam(value="level") String level) {
		List<Student> stulist=ser.searchStudentlevel(level);
		return new ResponseEntity<List<Student>>(stulist,HttpStatus.OK);
	}
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> stulist=ser.getAllStudents();
		return new ResponseEntity<List<Student>>(stulist,HttpStatus.OK);
	}
	@GetMapping("/getQuestions")
	public ResponseEntity<List<Object>> getQuestions(@RequestParam(value="levelCount") int levelCount,@RequestParam(value="level1Stat") String level1Stat,@RequestParam(value="level2Stat") String level2Stat,@RequestParam(value="level3Stat") String level3Stat,@RequestParam(value="subjectid") int subjectid){
		List<Object> queslist = null;
		System.out.println(levelCount);
		System.out.print(level1Stat);
		if(levelCount==1) {
			System.out.print("inside level1");
			queslist=ser.getQuestionsByLevels("Level1",subjectid);
		}
		else if((levelCount==2)&&(level1Stat.equalsIgnoreCase("pass"))) {
			queslist=ser.getQuestionsByLevels("Level2",subjectid);
		}
		else if((levelCount==3)&&(level2Stat.equalsIgnoreCase("pass"))) {
			queslist=ser.getQuestionsByLevels("Level3", subjectid);
		}
		else {
			return new ResponseEntity<List<Object>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<Object>>(queslist,HttpStatus.OK);
	}
	@GetMapping("/getStudentReport")
	public ResponseEntity<List<Object>> getStudentReport(@RequestParam(value="student_id") int student_id) {
		List<Object> studentrep=ser.repStudent(student_id);
		return new ResponseEntity<List<Object>>(studentrep,HttpStatus.OK);
	}
	@PostMapping("/createReport")
	public ResponseEntity<String> createReport(@RequestParam(value="level") String level,@RequestParam("score") int score,@RequestParam("status") String status,@RequestParam("examid") int examid,@RequestParam("userid") int userid){
			String msg=ser.createReport(level,score,status,examid,userid);
			return new ResponseEntity<String>("Report Created",new org.springframework.http.HttpHeaders(),HttpStatus.OK);
	}
	@PostMapping("/createStudentTakes")
	public ResponseEntity<String> createStudentTakes(@RequestParam(value="studentid") int studentid,@RequestParam(value="examid") int examid){
		ser.craeteStudentTakes(studentid, examid);
		return new ResponseEntity<String>("Report Created",new org.springframework.http.HttpHeaders(),HttpStatus.OK);
	}
	@GetMapping("/getAllExam")
	private ResponseEntity<List<Object>> getAllExam() {
		List<Object> examList = ser.getAllExam();
		return new ResponseEntity<List<Object>>(examList, HttpStatus.OK);
	}
	@GetMapping("/GetAllReport")
	private ResponseEntity<List<Object>> getAllReport() {
		List<Object> replist = ser.getAllReport();
		return new ResponseEntity<List<Object>>(replist, HttpStatus.OK);

	}
	@GetMapping("/getFileNames")
	private ResponseEntity<List<Object>> getFileNames(){
		List<Object> filelist=ser.getFileNames();
		return new ResponseEntity<List<Object>>(filelist,HttpStatus.OK);
	}
	
}
