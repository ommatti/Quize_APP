package com.quizeapp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizeapp.dto.APIResponse;
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
	
	// Save Question
	@PostMapping("/saveQuestion")
	public ResponseEntity<APIResponse> saveQuestion(@RequestBody QuestionDto questionDto) {
	    QuestionDto savedQuestion = questionService.saveQuestion(questionDto);
	    
	    APIResponse response = new APIResponse();
	    response.setMessage("Question Saved Successfully with Id: " + savedQuestion.getId());
	    response.setStatus("SUCCESS");
	    response.setStatusCode(HttpStatus.CREATED.value());
	    response.setTimeStamp(new Date());

	    return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// Get All Questions
	@GetMapping("/getAllQuestions")
	public ResponseEntity<APIResponse> getAllQuestions() {
	    List<Question> questions = questionService.getAllQuestion();

	    APIResponse response = new APIResponse();
	    response.setMessage("Total Questions Found: " + questions.size());
	    response.setStatus("SUCCESS");
	    response.setStatusCode(HttpStatus.OK.value());        // 200
	    response.setTimeStamp(new Date());

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// Get Questions By Difficulty Level
	@GetMapping("difficulty/{level}")
	public ResponseEntity<APIResponse> getByDifficaltyLevel(@PathVariable String level) {
	    List<Question> questions = questionService.getQuestionByDifficulty(level);

	    APIResponse response = new APIResponse();
	    response.setMessage("Questions Found with Difficulty [" + level + "]: " + questions.size());
	    response.setStatus("SUCCESS");
	    response.setStatusCode(HttpStatus.OK.value());        // 200
	    response.setTimeStamp(new Date());

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// Delete Question By Id
	@DeleteMapping("/deleteQuestion/{id}")
	public ResponseEntity<APIResponse> deleteQuestion(@PathVariable Long id) {
	    questionService.deleteQuestion(id);

	    APIResponse response = new APIResponse();
	    response.setMessage("Question Deleted Successfully with ID: " + id);
	    response.setStatus("SUCCESS");
	    response.setStatusCode(HttpStatus.OK.value());        // 200
	    response.setTimeStamp(new Date());

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// Update Question By Id
	@PutMapping("/updateQuestion/{id}")
	public ResponseEntity<APIResponse> updateQuestion(@PathVariable Long id,
	                                                   @RequestBody QuestionDto questionDto) {
	    QuestionDto updatedQuestion = questionService.updateQuestion(id, questionDto);

	    APIResponse response = new APIResponse();
	    response.setMessage("Question Updated Successfully with ID: " + updatedQuestion.getId());
	    response.setStatus("SUCCESS");
	    response.setStatusCode(HttpStatus.OK.value());        // 200
	    response.setTimeStamp(new Date());

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
