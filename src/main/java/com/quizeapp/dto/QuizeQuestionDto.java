package com.quizeapp.dto;

public class QuizeQuestionDto {

    private Long id;
	
	private String questionTitle;
	
	private String Option1;
	
	private String Option2;
	
	private String Option3;
	
	private String Option4;

	
	
	
	public QuizeQuestionDto(Long id, String questionTitle, String option1, String option2, String option3,
			String option4) {
		super();
		this.id = id;
		this.questionTitle = questionTitle;
		Option1 = option1;
		Option2 = option2;
		Option3 = option3;
		Option4 = option4;
	}

	public Long getId() {
		return id;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public String getOption1() {
		return Option1;
	}

	public String getOption2() {
		return Option2;
	}

	public String getOption3() {
		return Option3;
	}

	public String getOption4() {
		return Option4;
	}
	
	
}
