package com.quizeapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizeapp.dto.QuestionDto;
import com.quizeapp.entity.Question;
import com.quizeapp.repository.QuestionRepository;
import com.quizeapp.service.QuestionService;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final QuestionRepository questionRepository;

   

	private QuestionService questionService;
	
	public QuestionController(QuestionService questionService, QuestionRepository questionRepository) {
		super();
		this.questionService = questionService;
		this.questionRepository = questionRepository;
	}
	
	@PostMapping("/saveQuestion")
	public ResponseEntity<QuestionDto> saveQuestion(@RequestBody QuestionDto questionDto){
		
		QuestionDto QuestionSaved = questionService.saveQuestion(questionDto);
		
		return new ResponseEntity<>(QuestionSaved, HttpStatus.CREATED);
	}

	
	@GetMapping("/getAllQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		
		List<Question> questions = questionService.getAllQuestion();
		
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}
	
	@GetMapping("difficulty/{level}")
	public ResponseEntity<List<Question>> getByDifficaltyLevel(@PathVariable String level){
		
		List<Question> questionByDifficulty = questionService.getQuestionByDifficulty(level);
		
		return new ResponseEntity<>(questionByDifficulty, HttpStatus.OK);
	}
}
