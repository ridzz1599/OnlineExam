package com.lti.pojo;
/*
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Questions {
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="exam_id")
//	private Exam exam_ques;
	
	@Id
	private int QuestionNo;
	private String Question;
	private String Option1;
	private String Option2;
	private String Option3;
	private String Option4;
	private String Answers;
	private String Level_ques;
//	public Exam getExam_ques() {
//		return exam_ques;
//	}
//	public void setExam_ques(Exam exam_ques) {
//		this.exam_ques = exam_ques;
//	}
	public int getQuestionNo() {
		return QuestionNo;
	}
	public void setQuestionNo(int questionNo) {
		QuestionNo = questionNo;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getOption1() {
		return Option1;
	}
	public void setOption1(String option1) {
		Option1 = option1;
	}
	public String getOption2() {
		return Option2;
	}
	public void setOption2(String option2) {
		Option2 = option2;
	}
	public String getOption3() {
		return Option3;
	}
	public void setOption3(String option3) {
		Option3 = option3;
	}
	public String getOption4() {
		return Option4;
	}
	public void setOption4(String option4) {
		Option4 = option4;
	}
	public String getAnswers() {
		return Answers;
	}
	public void setAnswers(String answers) {
		Answers = answers;
	}
	
	
	public String getLevel_ques() {
		return Level_ques;
	}
	public void setLevel_ques(String level_ques) {
		Level_ques = level_ques;
	}
	public Questions(int questionNo, String question, String option1, String option2, String option3, String option4,
			String answers) {
		super();
		QuestionNo = questionNo;
		Question = question;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
		Answers = answers;
	}
	public Questions(int questionNo, String question, String option1, String option2, String option3, String option4,
			String answers, String level_ques) {
		super();
		QuestionNo = questionNo;
		Question = question;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
		Answers = answers;
		Level_ques = level_ques;
	}
	@Override
	public String toString() {
		return "Questions [QuestionNo=" + QuestionNo + ", Question=" + Question + ", Option1=" + Option1 + ", Option2="
				+ Option2 + ", Option3=" + Option3 + ", Option4=" + Option4 + ", Answers=" + Answers + ", Level_ques="
				+ Level_ques + "]";
	}
	
	
	
}
*/

import javax.persistence.*;
import org.apache.commons.csv.*;
//import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name="Questions")
public class Questions {
	
	//@Id
	/*
	 * @GeneratedValue(strategy=GenerationType.SEQUENCE) private long Qid;
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="exam_id")
	private Exam exam_ques;
	
	@Id
	@GeneratedValue
	//@CsvBindByName
	private int QuestionNo;
	
	//@CsvBindByName
	private String Question;
	
	//@CsvBindByName
	private String Option1;
	
	//@CsvBindByName
	private String Option2;
	
	//@CsvBindByName
	private String Option3;
	
	//@CsvBindByName
	private String Option4;
	
	//@CsvBindByName(column = "Answer")
	private String Answer;
	
	private String Level_ques;

	public Questions() {
	}

	public int getQuestionNo() {
		return QuestionNo;
	}

	public void setQuestionNo(int questionNo) {
		QuestionNo = questionNo;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getOption1() {
		return Option1;
	}

	public void setOption1(String option1) {
		Option1 = option1;
	}

	public String getOption2() {
		return Option2;
	}

	public void setOption2(String option2) {
		Option2 = option2;
	}

	public String getOption3() {
		return Option3;
	}

	public void setOption3(String option3) {
		Option3 = option3;
	}

	public String getOption4() {
		return Option4;
	}

	public void setOption4(String option4) {
		Option4 = option4;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}
	

	public String getLevel_ques() {
		return Level_ques;
	}

	public void setLevel_ques(String level_ques) {
		Level_ques = level_ques;
	}

	

	public Exam getExam_ques() {
		return exam_ques;
	}

	public void setExam_ques(Exam exam_ques) {
		this.exam_ques = exam_ques;
	}

	public Questions(String question, String option1, String option2, String option3, String option4, String answer,
			String level_ques) {
		super();
		Question = question;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
		Answer = answer;
		Level_ques = level_ques;
	}

	public Questions(int questionNo, String question, String option1, String option2, String option3, String option4,
			String answer, String level_ques) {
		super();
		QuestionNo = questionNo;
		Question = question;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
		Answer = answer;
		Level_ques = level_ques;
	}
	
	

	public Questions(Exam exam_ques, int questionNo, String question, String option1, String option2, String option3,
			String option4, String answer, String level_ques) {
		super();
		this.exam_ques = exam_ques;
		QuestionNo = questionNo;
		Question = question;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
		Answer = answer;
		Level_ques = level_ques;
	}

	@Override
	public String toString() {
		return "Questions [exam_ques=" + exam_ques + ", QuestionNo=" + QuestionNo + ", Question=" + Question
				+ ", Option1=" + Option1 + ", Option2=" + Option2 + ", Option3=" + Option3 + ", Option4=" + Option4
				+ ", Answer=" + Answer + ", Level_ques=" + Level_ques + "]";
	}

	/*@Override
	public String toString() {
		return "Questions [QuestionNo=" + QuestionNo + ", Question=" + Question + ", Option1=" + Option1 + ", Option2="
				+ Option2 + ", Option3=" + Option3 + ", Option4=" + Option4 + ", Answer=" + Answer + ", Level_ques="
				+ Level_ques + "]";
	}*/
	
}
