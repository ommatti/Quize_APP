package com.quizeapp.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.quizeapp.dto.QuestionDto;
import com.quizeapp.entity.Question;
import com.quizeapp.repository.QuestionRepository;

@Service
public class QuestionService {

    
	
	private QuestionRepository repository;
	
	private ModelMapper modelMapper;

	
	public QuestionService(QuestionRepository repository, ModelMapper modelMapper) {
		super();
		this.repository = repository;
		this.modelMapper = modelMapper;
		
	}

	//-------------Save Question Method-----------
	public QuestionDto saveQuestion(QuestionDto questionDto) {
		
		 Question question = modelMapper.map(questionDto,Question.class);
		 System.out.println("Objects are Converted to Entiy");
		 Question savedQuestion = repository.save(question);
		 System.out.println("Question Saved In Database");
		 QuestionDto dto = modelMapper.map(savedQuestion, QuestionDto.class);
		 System.out.println("Objects are converted to DTO");
		 System.out.println("Question id is : " + dto.getId());
		 
		 return dto;
		
	}

	//Return all Questions
	public List<Question> getAllQuestion() {
		
		List<Question> questions = repository.findAll();
		
		return questions;
	}
	
	
	//Return Questions By Difficulty level
	public List<Question> getQuestionByDifficulty(String level) {
	    
	    List<Question> questionsByDifficulty = repository.findByDifficaltyLevel(level);
	    
	    return questionsByDifficulty;
	}
	


	
}
