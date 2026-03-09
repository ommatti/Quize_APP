package com.quizeapp.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizeapp.dto.APIResponse;
import com.quizeapp.entity.Quiz;
import com.quizeapp.service.QuizService;

@RestController
@RequestMapping("/api/v1/quize")
public class QuizController {

	private QuizService quizService;

	public QuizController(QuizService quizService) {
		super();
		this.quizService = quizService;
	}

	// Create Quiz
	@PostMapping("/category/")
	public ResponseEntity<APIResponse> createQuiz(@RequestParam String category, @RequestParam int noOfQuestions,
			@RequestParam String title) {

		Quiz quiz = quizService.createQuiz(category, noOfQuestions, title);

		APIResponse response = new APIResponse();
		response.setMessage("Quiz Created Successfully with Title: " + quiz.getTitle() + " | Total Questions: "
				+ quiz.getQuestions().size());
		response.setStatus("SUCCESS");
		response.setStatusCode(HttpStatus.CREATED.value()); // 201
		response.setTimeStamp(new Date());

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
