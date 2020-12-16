package com.lti.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lti.controller.CSVHelper;
import com.lti.pojo.Exam;
import com.lti.pojo.Questions;
import com.lti.repository.ExamRepository;
import com.lti.repository.QuestionsRepository;

@Service
public class QuestionService {

	
	@Autowired
	private QuestionsRepository quesrepo;

	@Autowired
	private ExamRepository exrepo;
	
	public void save(MultipartFile file,String examname,int duration,int noofques,int passscore,String filename) {
		// TODO Auto-generated method stub
		try {
			 	List<Questions> ques = CSVHelper.csvToQuestions(file.getInputStream());
//			 	quesrepo.saveAll(ques);
//			 	
				/*Exam e=new Exam(1,"Java",20,30,40,ques);
				exrepo.save(e);*/
			 	
//			 	Exam e=new Exam(1,"Java",20,30,40);
//			 	exrepo.save(e);
//			 	
//			 	e.setQues(ques);
//			 	exrepo.save(e);
//			 	
			 	Questions question;
			 	Exam e=new Exam(examname,duration,noofques,passscore,filename);
			 	for(Questions q:ques) {
			 		question=q;
			 		question.setExam_ques(e);
			 		e.getQues().add(question);
			 		exrepo.save(e);
			 	}
		    } catch (IOException e) {
		      throw new RuntimeException("Fail to store csv data: " + e.getMessage());
		    }
	}
	
	/*public List<Questions> getAllQuestions() {
		// TODO Auto-generated method stub
		return quesrepo.findAll();
	}	*/
}
