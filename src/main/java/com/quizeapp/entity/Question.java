package com.quizeapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String questionTitle;
	
	private String Option1;
	
	private String Option2;
	
	private String Option3;
	
	private String Option4;
	
	private String rightAnswer;
	
	private String difficaltyLevel;
	
	 private String category; 

	public String getCategory() {
		return category;
	}

	 public void setCategory(String category) {
		 this.category = category;
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
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

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getDifficaltyLevel() {
		return difficaltyLevel;
	}

	public void setDifficaltyLevel(String difficaltyLevel) {
		this.difficaltyLevel = difficaltyLevel;
	}
	
	

}
